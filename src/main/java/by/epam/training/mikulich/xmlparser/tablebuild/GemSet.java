package by.epam.training.mikulich.xmlparser.tablebuild;

import java.io.Serializable;
import java.util.Set;

public class GemSet implements Serializable {
    private static final long serialVersionUID = 1693L;
    
    private Set set;
    public GemSet() {
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Set getSet() {
        return set;
    }

    public GemSet(Set set){
    	System.out.println("7");
        this.set=set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GemSet tariffSet = (GemSet) o;
        return (set == tariffSet.getSet() || (set != null && set.equals(tariffSet.getSet())));

    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (set == null ? 0 : set.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass());
        builder.append(" set = ").append(set);
        return builder.toString();
    }
}
