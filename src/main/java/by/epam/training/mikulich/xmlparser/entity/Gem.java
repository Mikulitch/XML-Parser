package by.epam.training.mikulich.xmlparser.entity;
import java.io.Serializable;


public class Gem implements Serializable, Comparable<Gem> {
    private static final long serialVersionUID = 14L;
    private Integer id ; 
    private String name;
    private Preciousness preciousness;
    private String origin;
    private VisualPar visualPar;
    private Double value;
 

    public Gem() {
    }
    
    public Gem(int id, String name, Preciousness preciousness, String origin, VisualPar visualPar, double value) {
        this.id = id;
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.visualPar = visualPar;
        this.value = value;
      
    }

    public Gem(Gem gem) {
        this.name = gem.getName();
        this.id = gem.getId();
        this.preciousness = gem.getPreciousness();
        this.origin = gem.getOrigin();
        this.visualPar = gem.visualPar;
        this.value = gem.getValue();
       
    }
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
 public VisualPar getVisualPar() {
	return visualPar;
}
 public void setVisualPar(VisualPar visualPar) {
	this.visualPar = visualPar;
}
    public Integer getId() {
		return id;
	}
   
    public void setId(Integer id) {
		this.id = id;
	}
   
    public String getName() {
		return name;
	}
   
    public void setName(String name) {
		this.name = name;
	}
    
    public Preciousness getPreciousness() {
		return preciousness;
	}
   
    public void setPreciousness(Preciousness preciousness) {
		this.preciousness = preciousness;
	}
    
 
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Gem gem = (Gem) o;
        return (name == gem.name || (gem.name != null && name.equals(gem.name))) &&
                (id == gem.id || (id != null && id.equals(gem.id))) &&
                (preciousness == gem.preciousness || (preciousness != null && preciousness.equals(gem.preciousness))) &&
                (origin == gem.origin || (origin != null && origin.equals(gem.origin))) &&
                (visualPar == gem.visualPar || (visualPar != null && visualPar.equals(gem.visualPar))) &&
                (value == gem.value || (value != null && value.equals(gem.value)));
    }

    @Override
    public int hashCode() {
        final int prime = 22;
        int result = 1;
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (preciousness == null ? 0 : preciousness.hashCode());
        result = prime * result + (origin == null ? 0 : origin.hashCode());
        result = prime * result + (visualPar == null ? 0 : visualPar.hashCode());
        result = prime * result + (value == null ? 0 : value.hashCode());
       
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass());
        builder.append(" name = ").append(name);
        builder.append(" id = ").append(id);
        builder.append(" preciousness = ").append(preciousness);
        builder.append(" origin = ").append(origin);
        builder.append(" visualPar = ").append(visualPar);
        builder.append(" value = ").append(value);
       
        return builder.toString();
    }

    @Override
    public int compareTo(Gem o) {
        int result = this.id - o.getId();
        if (result == 0) {
            result = this.name.compareTo(o.getName());
        }
        return result;
    }

	
}
