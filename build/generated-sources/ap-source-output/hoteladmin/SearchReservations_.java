package hoteladmin;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-09-10T12:08:36")
@StaticMetamodel(SearchReservations.class)
public class SearchReservations_ { 

    public static volatile SingularAttribute<SearchReservations, Short> roomNr;
    public static volatile SingularAttribute<SearchReservations, Integer> bill;
    public static volatile SingularAttribute<SearchReservations, Integer> id;
    public static volatile SingularAttribute<SearchReservations, String> services;
    public static volatile SingularAttribute<SearchReservations, Date> resTo;
    public static volatile SingularAttribute<SearchReservations, Date> resFrom;

}