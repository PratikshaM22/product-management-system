package productDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	@Override
	public void addProduct(Product p) {
		// TODO Auto-generated method stub
		
		try {
            con = ProductDBConnection.getConnection();
            String sql = "INSERT INTO Productinfo(pid, pname, price, category, quantity) VALUES(?,?,?,?,?)";
            ps = con.prepareStatement(sql);
            ps.setInt(1, p.getPid());
            ps.setString(2, p.getPname());
            ps.setDouble(3, p.getPrice());
            ps.setString(4, p.getCategory());
            ps.setInt(5, p.getQuantity());

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Product added successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
		
	
	@Override
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		
		try {
            con = ProductDBConnection.getConnection();
            String sql = "UPDATE Productinfo SET pname=?, price=?, category=?, quantity=? WHERE pid=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getPname());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getCategory());
            ps.setInt(4, p.getQuantity());
            ps.setInt(5, p.getPid());

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Product updated successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public void deleteProduct(int pid) {
		// TODO Auto-generated method stub
		
		try {
            con = ProductDBConnection.getConnection();
            String sql = "DELETE FROM Productinfo WHERE pid=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pid);

            int i = ps.executeUpdate();
            if (i > 0) {
                System.out.println("Product deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Product searchProduct(int pid) {
		// TODO Auto-generated method stub
		
		Product p = null;
        try {
            con = ProductDBConnection.getConnection();
            String sql = "SELECT * FROM Productinfo WHERE pid=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();

            if (rs.next()) {
                p = new Product(
                    rs.getInt("pid"),
                    rs.getString("pname"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getInt("quantity")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
		
	}

	@Override
	public List<Product> displayAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product> list = new ArrayList<>();
        try {
            con = ProductDBConnection.getConnection();
            String sql = "SELECT * FROM Productinfo";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Product p = new Product(
                    rs.getInt("pid"),
                    rs.getString("pname"),
                    rs.getDouble("price"),
                    rs.getString("category"),
                    rs.getInt("quantity")
                );
                list.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    
	}




@Override
public List<Product> searchByCategory(String category) {

    List<Product> list = new ArrayList<>();

    try {
        con = ProductDBConnection.getConnection();

        String sql = "SELECT * FROM Productinfo WHERE category=?";

        ps = con.prepareStatement(sql);

        ps.setString(1, category);

        rs = ps.executeQuery();

        while(rs.next()) {

            Product p = new Product(
                rs.getInt("pid"),
                rs.getString("pname"),
                rs.getDouble("price"),
                rs.getString("category"),
                rs.getInt("quantity")
            );

            list.add(p);
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return list;
}
}
