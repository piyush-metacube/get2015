package socialnetwork.core;

public class Organisation extends Entity {
    private String fieldString; // ..medical,engineering,research,etc etc
    private int establishmentYear;

    public Organisation(String email, String name, String fieldString, int establishmentYear) {
	super(email, name);
	this.fieldString = fieldString;
	this.establishmentYear = establishmentYear;
    }

    public String getFieldString() {
	return fieldString;
    }

    public void setFieldString(String fieldString) {
	this.fieldString = fieldString;
    }

    public int getEstablishmentYear() {
	return establishmentYear;
    }

    public void setEstablishmentYear(int establishmentYear) {
	this.establishmentYear = establishmentYear;
    }

    @Override
    public String toString() {
	return super.toString() + "[fieldString=" + fieldString + ", establishmentYear=" + establishmentYear + "]";
    }

    @Override
    public boolean equals(Object object) {
	if (object == null || !(object instanceof Organisation)) {
	    return false;
	} else {
	    Organisation organisation = (Organisation) object;
	    if (this.fieldString.equalsIgnoreCase(organisation.getFieldString())) {
		return true;
	    }
	}
	return false;
    }

    @Override
    public int hashCode() {
	int hash = 3;
	hash = 7 * hash + this.fieldString.hashCode();
	return hash;
    }

}
