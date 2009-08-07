/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.b3p.suf2;

/**
 *
 * @author Gertjan
 */
public class SUF2Coordinate {

    public double x;
    public double y;
    private Tag tag;

    public enum Tag {

        I1("eerste punt van een object"),
        I2("rechtlijnige verbinding met het vorige punt"),
        I4("cirkelboogverbinding met het vorige punt");
        String description;

        private Tag(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public SUF2Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public SUF2Coordinate(double x, double y, Tag tag) {
        this.x = x;
        this.y = y;
        this.tag = tag;
    }

    public void deleteTag() {
        tag = null;
    }

    public Tag getTag() {
        return tag;
    }

    public boolean hasTag() {
        return tag != null;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public String toString() {
        return "Coordinaat(" + x + ", " + y + ")" + (tag == null ? "" : " tag:" + tag.toString() + " (" + tag.getDescription() + ")");
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
