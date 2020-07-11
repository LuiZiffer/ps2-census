# ps2-census-java

*ps2-census* is an unofficial wrapper of the [Planetside 2 Census API](http://census.daybreakgames.com/) written in Java.
The project itself was inspired by [spascou's ps2-census for python](https://github.com/spascou/ps2-census) and its methods and class structure leans heavily on his.
This design choice was made to ensure that usage of this tool is as intuitive as possible.
The description and structure of this readme have been adopted from [spascou](https://github.com/spascou/ps2-census) and adjusted for this project.

   * [ps2-census](#ps2-census)
      * [Dependencies](#dependencies)
		* [Apache Maven](#apache-maven)
		* [Gradle](#gradle)
      * [Examples](#examples)
      * [Query building](#query-building)
         * [Basic query](#basic-query)
         * [Simple join](#simple-join)
         * [Nesting joins](#nesting-joins)
            * [Deeply nested join](#deeply-nested-join)
            * [Lateraly nested joins](#lateraly-nested-joins)
         * [Tree](#tree)
      * [Common enums](#common-enums)
      * [Event Stream](#event-stream)
         * [Usage](#usage)
      * [Similar projects](#similar-projects)

*Features*:
- Build queries through method chaining
- Join collections and nest them through method chaining
- Get raw (deserialized) responses as JsonNodes
- Parse raw (deserialized) responses into a corresponding list of tree structures
- Access common enums directly
- Subscribe to event streams

By default the `example` service ID is used; however it is not recommended for production.
You should get your own service ID from the webside below and supply it to the client whenever needed.

More information about the Census API is available on the official Census documentation [here](http://census.daybreakgames.com/).

[Iridar's blog](https://iridar-mirror.knyazev.io/index.html%3Fp=4127.html) is also recommended to understand
the quirks of this particular API as this knowledge is necessary to use *ps2-census* properly.

## Dependencies

### Apache Maven
```sh
<dependency>
  <groupId>io.github.luiziffer</groupId>
  <artifactId>ps2-census</artifactId>
  <version>0.1.2</version>
</dependency>
```

### Gradle

```sh
implementation 'io.github.luiziffer:ps2-census:0.1.2'
```

## Query building

Queries are made on collections with optional joins on other collections as well as various commands that alter the output.

A Census API collection is analog to a relation in a generic relational database system, and a Census API join is analog to a join between these relations.

### Basic query

To build a query, instantiate the `Query` class with a `Collection` (and your service ID,
though it will be omitted in next examples for conciseness):
```java
import census.Query;
import census.anatomy.Collection;

Query query = new Query(Collection.ITEM, service_id=YOUR_SERVICE_ID);
```

Chain methods to alter the query further:
```java
Query query = new Query(Collection.ITEM)
    .lang("en")
    .sort(("item_id", 1), ("faction_id", -1))
    .limit(30)
    [...];
```

Available methods are:
- `filter(String, SearchModifier, String...)`: filter the query on a field; `census.anatomy.SearchModifier` contains all the modifiers made available by the Census API (`SearchModifier.CONTAINS`, `SearchModifier.LESS_OR_EQUAL`, ...)
- `show(String...)`: only return the provided fields in results
- `hide(String...)`: do not return the provided fields in results
- `sort(Pair<String,Integer>...)`: sort the results by field, either in increasing or decreasing order
- `has(String...)`: only return results which have the specified fields
- `case(boolean)`: whether `filter()`s are case sensive or not; default to `True`
- `limit(int arg)`: limit the return to *at most* `arg` results; required in tendem with `start()` for queries having too large of a result and therefore fail; defaults to `1`
- `limit_per_db(int arg)`: limit the return to *at most* `arg * databases count` results; useful when querying the `Collection.CHARACTER` collection whose objects are randomly distributed among multiple databases in order to have more predictable results
- `start(int)`: start with the `arg`th object within the results of the query
- `include_null(boolean)`: whether to include keys with `None` values in results; defaults to `False`
- `lang(String)`: only keep the supplied language for internationalized strings
- `join(census.Join)`: perform a collection join; see the following documentation for additional details
- `tree(census.Tree)`: rearrange lists of data into trees; see the following documentation for additional details
- `timing(boolean)`: show query timing information
- `exact_match_first(boolean)`: when using `filter()`s with `SearchModifier`s, put exact matches at the top of the results list disregarding `sort()`s
- `distinct(String)`: get the distinct values for a certain field
- `retry(boolean)`: retry queries at most one time before failing; defaults to `True`

Execute the query in one of the 2 ways made available by the Census API:

- `.count()` to get the items count
```java
query.count();
> 21048
```

- `.get()` to get the results
```java
query.get();
> {'item_list': [{...}, {...}, ...], 'returned': 30}
```

`count()` and `get()` calls are when the query is actually sent to the Census API endpoint.
They will raise status exceptions if appropriate.

### Simple join

In order to perform joins instantiate the `Join` class with a `Collection`, add any additional
chained methods to it, and pass it to the `Query` object via `query.join()`:
```java
from ps2_census import Collection, Join, Query
import census.Query;
import census.Join;
import census.anatomy.Collection;

Query query = new Query(Collection.ITEM)
    .join(
        new Join(Collection.WEAPON_DATASHEET)
        .outer(0)
        .on("item_id")
        .to("item_id")
        .inject_at("weapon_datasheet")
        [...]
    );
```

Available `Join` methods are:
- `join(Join...)`: nest another join within this one; see the following documentation for additional details
- `on(String)`: specify the field on this collection (the `Query` or parent `Join`) to join on; if not provided will default to this collection's ID (`{this_type}_id`)
- `to(String)`: specify the field on the other collection (the `Join`'s) to join to; if not provided will default to the `on` value
- `list(int)`: whether the joined data is a list (and therefore will result in a list of objects) or not; `1` if it is a list, `0` if not; default to `0`
- `show(String...)`: only keep the provided fields in results
- `hide(String...)`: do not keep the provided fields in results
- `inject_at(String)`: the field name where the joined data will be injected in the parent element (`Query` result item or parent `Join` element)
- `terms(Pair<String,String>[])`: filter the join result by a dictionary of conditions (eg. `{"faction_id": 1, "skill_set_id": 129}`)
- `outer(int)`: whether the join will perform an outer join (include non-matches) of an inner join (exclude non-matches); `1` for outer, `0` for inner; defaults to `1`

Multiple joins can be performed one after another on the same `Query` and the trees will be merged in
the result:
```java
Query query = new Query(Collection.ITEM)
    .join(
        new Join(Collection.WEAPON_DATASHEET)
    )
    .join(
        new Join(Collection.ITEM_TO_WEAPON)
    );
```
### Nesting joins

`Join`s can be nested one into another both deeply and lateraly. Nesting is done by reference: each `Join` instance
contains a list of references to its nested `Join`s.

*Note*: be careful about modifying the `Join` instances after their creation if you assign them to locals
for convenience, as shown in the following examples.
As nesting is done by reference and the whole structure is "compiled" (into a querystring) on the call
to `query.join()`, if any modification is done to an instance between its creation and the resolution,
it will indirectly impact the result of any other parent and/or nested `Join`.

#### Deeply nested join

Deeply nested join are necessary in order to access data structures deeper in the collections tree.
To deeply nest joins, instantiate the `Join` class multiple times and combine them through
`join1.join(join2.join(join3))` where `join3` is nested within `join2` and `join2` is nested within `join1`:
```java
import census.Query;
import census.Join;
import census.anatomy.Collection;
import census.enums;

Join item_to_weapon_join = new Join(Collection.ITEM_TO_WEAPON)
    .on("item_id")
    .to("item_id")
    .inject_at("item_to_weapon");

Join weapon_join = new Join(Collection.WEAPON)
    .on("weapon_id")
    .to("weapon_id")
    .inject_at("weapon");

Join weapon_to_fire_group_join = new Join(Collection.WEAPON_TO_FIRE_GROUP)
    .on("weapon_id")
    .to("weapon_id")
    .inject_at("weapon_to_fire_group");

Query query = new Query(Collection.ITEM)
    .filter("item_type_id", ItemType.WEAPON)
    .join(
        item_to_weapon_join.join(
            weapon_join.join(
                weapon_to_fire_group_join
            )
        )
    );
```

#### Lateraly nested joins

Lateraly nested joins are necessary in order to access data structures at the same depth in the collections tree.
To laterally nest joins, instantiate the `Join` class multiple times and combine them through
`join1.join(join2).join(join3)` or `join1.join(join2, join3)` where `join2` and `join3` are nested within `join1`:

```java
import census.Query;
import census.Join;
import census.anatomy.Collection;

Join fire_group_to_fire_mode_join = new Join(Collection.FIRE_GROUP_TO_FIRE_MODE)
    .outer(0)
    .on("fire_group_id")
    .to("fire_group_id")
    .list(1)
    .inject_at("fire_group_to_fire_modes");

Join fire_mode_join = new Join(Collection.FIRE_MODE_2)
    .outer(0)
    .on("fire_mode_id")
    .to("fire_mode_id")
    .inject_at("fire_mode");

Join fire_mode_to_projectile_join = new Join(Collection.FIRE_MODE_TO_PROJECTILE)
    .outer(0)
    .on("fire_mode_id")
    .to("fire_mode_id")
    .inject_at("fire_mode_to_projectile");

Join player_state_group_join = new Join(Collection.PLAYER_STATE_GROUP_2)
    .outer(0)
    .on("player_state_group_id")
    .to("player_state_group_id")
    .list(1)
    .inject_at("player_state_groups");

Query query = new Query(Collection.WEAPON_TO_FIRE_GROUP)
    .join(
        fire_group_to_fire_mode_join
        .join(
            fire_mode_join
            .join(fire_mode_to_projectile_join)
            .join(player_state_group_join)
        )
    )
)
```

### Tree

Trees are also built using their own class, `Tree`, then passed to the `Query` object:
```java
import census.Query;
import census.Tree;
import census.anatomy.Collection;

Query query = new Query(Collection.ITEM)
    .tree(
        new Tree("name.en")
        .prefix("en_name_")
        [...]
    );
```

This will return a list of items with their english name prefixed by `en_name_` as keys
and the objects themselves as values, instead of a flat list of items.

Available methods are:
- `list(int)`: `0` if tree data is not a list, `1` if it is a list; defaults to `0`
- `prefix(String)`: prefix to add to the field value
- `start(String)`: where the tree starts; defaults to the root (root list objects will be formatted as a tree)

## Common enums

Census API data uses a lot of integer enumerations that are collections themselves.

For example the `faction_id` key in items from `Collection.ITEM` is an integer that represents
a specific fation, refering to `Collection.FACTION`: Vanu is `1`, NC is `2` etc.

In order to reduce the amount of necessary joins, which are arguably the most complex part of Census queries,
some common enumerations are provided in `census.enums`, including:
- ArmorFacing
- FacilityType
- Faction
- FireModeType
- ItemType
- ItemCategory
- MetagameEventState
- PlayerState
- ProjectileFlightType
- ResistType
- ResourceType
- RewardType
- TargetType
- Vehicle
- World

These typically do not change often and *ps2-census* will be updated whenever there is such a change.

They can be used just for reference, but also in queries for filtering.

See the following example for filtering weapon items only using `census.enums.ItemType`:
```java
import census.query;
import census.enums.ItemType;

Query query = new Query(Collection.ITEM)
    .filter("item_type_id", ItemType.WEAPON.toString());
```

## Event Stream

*ps2-census* offers a client that handles connection to the WebSocket endpoint, subscription
to various streams and reception of the events. In the event of a disconnect, the client will wait for roughly 90 seconds and then close the websocket connection.
This will likely cause the client to call the `onFailure(...)` methods contained in the listeners. The connection can be resumed by the `resume()` method.

### Usage

This is a basic example on how to connect and subscribe. For more in depth information have a look at the examples folder.
The `GenericEventPrinter` class inherits from `EventStreamListener` and simply prints any messages or status changes to standard out.
This example will connect to the event stream, subscribe to all player deaths, print everything for 10 seconds and then disconnect.

```java
EventStreamClient client = EventStreamClient.getInstance();
GenericEventPrinter listener = new GenericEventPrinter();

client.addEventListeners(printer);
client.connect();
client.subscribe(GenericCharacter.ALL.toString(), CharacterEvent.DEATH);

try {
	TimeUnit.SECONDS.sleep(10);
	client.close();
} catch (InterruptedException | IOException e) {
	e.printStackTrace();
	Thread.interrupted();
}
```

NOTE: The following example works, but doesn't call the `onClosing(...)` and `onClosed(...)` methods of listeners.
To circumvent this issue simply add a one or two second delay after the connection was closed.

```java
try (EventStreamClient client = EventStreamClient.getInstance())
{
	GenericEventPrinter listener = new GenericEventPrinter();

	client.addEventListeners(printer);
	client.connect();
	client.subscribe(GenericCharacter.ALL.toString(), CharacterEvent.DEATH);

	try {
		TimeUnit.SECONDS.sleep(10);
		client.close();
	} catch (InterruptedException | IOException e) {
		e.printStackTrace();
		Thread.interrupted();
	}
}

//Add delay here
```

More information about the Planetside2 Census event stream can be found at [here](http://census.daybreakgames.com/#what-is-websocket).


## Similar projects

- *leonhard-s*' [auraxium](https://github.com/leonhard-s/auraxium)
- *spascou* [ps2-census](https://github.com/spascou/ps2-census)
