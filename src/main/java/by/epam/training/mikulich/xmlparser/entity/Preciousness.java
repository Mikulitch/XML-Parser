package by.epam.training.mikulich.xmlparser.entity;

public enum Preciousness {
	
	PRECIOS("Драгоценный"),
	   NONPRECIOS("Полудрагоценный");
	    

	    private final String value;

	    Preciousness(String v) {
	        value = v;
	    }

	    public String value() {
	        return value;
	    }

	    public static Preciousness fromValue(String value) {
	        for (Preciousness currentEnum: Preciousness.values()) {
	            if (currentEnum.value.equals(value)) {
	                return currentEnum;
	            }
	        }
	        throw new IllegalArgumentException(value);
	    }
}

	
	


