package hoteladmin;

import hoteladmin.Reservations;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-10T12:08:36")
@StaticMetamodel(Guest.class)
public class Guest_ { 

    public static volatile SingularAttribute<Guest, String> lastName;
    public static volatile SetAttribute<Guest, Reservations> reservations;
    public static volatile SingularAttribute<Guest, String> city;
    public static volatile SingularAttribute<Guest, String> phone;
    public static volatile SingularAttribute<Guest, String> street;
    public static volatile SingularAttribute<Guest, String> name;
    public static volatile SingularAttribute<Guest, Integer> id;

}