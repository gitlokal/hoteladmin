package hoteladmin;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-14T18:41:33")
@StaticMetamodel(Reservations.class)
public class Reservations_ { 

    public static volatile SingularAttribute<Reservations, Date> res_to;
    public static volatile SingularAttribute<Reservations, Integer> room_nr;
    public static volatile SingularAttribute<Reservations, Float> bill;
    public static volatile SingularAttribute<Reservations, Date> res_from;
    public static volatile SingularAttribute<Reservations, Integer> guest;
    public static volatile SingularAttribute<Reservations, Integer> id;
    public static volatile SingularAttribute<Reservations, String> services;

}