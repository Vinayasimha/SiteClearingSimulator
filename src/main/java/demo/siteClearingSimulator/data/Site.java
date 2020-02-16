/**
 *
 */
package demo.siteClearingSimulator.data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Vinayasimha Patil
 *
 */
public class Site {

    private List<List<SiteSquare>> siteSquares;

    public static Site buildSite(String siteMapFilePath) {
        List<List<SiteSquare>> siteSquares = new ArrayList<>();

        File siteMapFile = new File(siteMapFilePath);
        try (Stream<String> rows = Files.lines(siteMapFile.toPath())) {
            rows.map(String::chars)
                    .forEach(intStream -> {
                        List<SiteSquare> rowSiteSquares = intStream.mapToObj(integer -> (char) integer)
                                .map(SiteSquare::buildSiteSquare)
                                .collect(Collectors.toList());
                        siteSquares.add(rowSiteSquares);
                    });

        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }

        Site site = new Site();
        site.setSiteSquares(siteSquares);
        return site;
    }

    public List<List<SiteSquare>> getSiteSquares() {
        return siteSquares;
    }

    public void setSiteSquares(List<List<SiteSquare>> siteSquares) {
        this.siteSquares = siteSquares;
    }

    @Override
    public String toString() {
        StringBuilder siteMap = new StringBuilder();
        siteSquares.forEach(row -> {
            row.forEach(siteMap::append);
            siteMap.append(System.lineSeparator());
        });

        return siteMap.toString();
    }
}
