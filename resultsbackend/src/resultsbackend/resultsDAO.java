package resultsbackend;
import resultsbackend.Students;
import java.sql.Connection;
import resultsbackend.DBconfiguration;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;
public class resultsDAO {
	  DBconfiguration db = new DBconfiguration();
	  Connection con=db.getDB();
           public void  addresults(Students resu) {
        	   try {
        		   String query="insert into resultdata values(?,?,?,?,?,?,?,?)";
        		   PreparedStatement ps= con.prepareStatement(query);
				    ps.setInt(1, resu.getPinnumber());
				    ps.setString(2,resu.getName());
				    ps.setString(3,resu.getGender());
				    ps.setInt(4,resu.getEnglish());
				    ps.setInt(5,resu.getMaths());
				    ps.setInt(6,resu.getPhysics());
				    ps.setInt(7,resu.getChemistry());
				    ps.setInt(8,resu.getTelugu());
				    ps.execute();
				    System.out.println("students result add succesfully");
			} catch (Exception e){
                    System.out.println("result not added");
				
			}}
        	   public List<Students>displayresults(){
        		   List<Students> empList = new ArrayList<Students>();
        		   try {
					String query="Select * from resultdata";
					PreparedStatement ps = con.prepareStatement(query);
					ResultSet st = ps.executeQuery();
					Students resu = new Students();
					while(st.next()) {
					resu.setName(st.getString("name"));
					resu.setPinnumber(st.getInt("pinnumber"));
					resu.setGender(st.getString("gender"));
					resu.setTelugu(st.getInt("telugu"));
					resu.setEnglish(st.getInt("english"));
					resu.setMaths(st.getInt("maths"));
					resu.setPhysics(st.getInt("physics"));
					resu.setChemistry(st.getInt("chemistry"));
					empList.add(resu);
					}
				} catch (Exception e) {
					System.out.println("data not found");
				}
        		   return empList;
        	  }
        	   public Students displayresults( int pinNumber){
        			Students resu = new Students();
        			resu.setPinnumber(0);
        		   try {
					String query="Select * from resultdata where pinnumber=?";
					PreparedStatement ps = con.prepareStatement(query);
				    ps.setInt(1, pinNumber);
					
					ResultSet st = ps.executeQuery();
				
					
					if(st.next()) {
						
						 resu.setName(st.getString("name"));
						  resu.setPinnumber(st.getInt("pinnumber"));
						resu.setGender(st.getString("gender")); resu.setTelugu(st.getInt("telugu"));
						 resu.setEnglish(st.getInt("english")); resu.setMaths(st.getInt("maths"));
						 resu.setPhysics(st.getInt("physics"));
						 resu.setChemistry(st.getInt("chemistry"));
						
					}
				} catch (Exception e) {
					
					System.out.println("results not fund");
				}
        		   return resu;
        	  }
           }


