//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package census;

import census.anatomy.Collection;
import census.anatomy.Constants;
import census.exception.CensusException;
import census.exception.CensusInvalidSearchTermException;
import census.query.dto.ICensusCollection;
import census.query.dto.internal.Item;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.imageio.ImageIO;

public class ItemIcon {
    private String image_path;
    private String item_id;
    private String service_id;

    public ItemIcon(String image_path) {
        this.image_path = image_path;
    }

    public ItemIcon(String item_id, String service_id) {
        this.item_id = item_id;
        this.service_id = service_id;
    }

    public String url() throws CensusException, IOException {
        if (this.image_path == null) {
            Query q = (new Query(Collection.ITEM, this.service_id)).filter("item_id", new String[]{this.item_id})
                    .show(new String[]{"image_path"});
            List<ICensusCollection> list = q.getAndParse();
            if (list == null || list.isEmpty()) {
                return null;
            }

            this.image_path = ((Item)list.get(0)).getImage_path();
        }

        return Constants.CENSUS_ENDPOINT.toString() + this.image_path;
    }

    public BufferedImage get() throws MalformedURLException, IOException, CensusException {
        String url = this.url();
        return url != null ? ImageIO.read(new URL(url)) : null;
    }
}
