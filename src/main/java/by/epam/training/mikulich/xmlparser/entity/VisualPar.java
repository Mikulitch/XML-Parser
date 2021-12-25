package by.epam.training.mikulich.xmlparser.entity;

import java.io.Serializable;

public class VisualPar implements Serializable {
    private static final long serialVersionUID = 12L;
    private String color;
    private Integer transparency;
    private Integer facets;

    public VisualPar() {
    }

    public VisualPar(String color, Integer transparency, Integer facets) {
        this.color = color;
        this.transparency = transparency;
        this.facets = facets;
    }

    public String getColor() {
		return color;
	}
    public void setColor(String color) {
		this.color = color;
	}
    public Integer getFacets() {
		return facets;
	}
    public void setFacets(Integer facets) {
		this.facets = facets;
	}
    public Integer getTransparency() {
		return transparency;
	}
    public void setTransparency(Integer transparency) {
		this.transparency = transparency;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VisualPar visualPar = (VisualPar) o;
        return  (color == visualPar.color || (color != null && color.equals(visualPar.color))) &&
                (transparency == visualPar.transparency || (transparency != null && transparency.equals(visualPar.transparency))) &&
                (facets == visualPar.facets || (facets != null && facets.equals(visualPar.facets)));

    }

    @Override
    public int hashCode() {
        final int prime = 21;
        int result = 1;
        result = prime * result + (color == null ? 0 : color.hashCode());
        result = prime * result + (transparency == null ? 0 : transparency.hashCode());
        result = prime * result + (facets == null ? 0 : facets.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass());
        builder.append(" color = ").append(color);
        builder.append(" transparency = ").append(transparency);
        builder.append(" facets = ").append(facets);
        return builder.toString();
    }
}