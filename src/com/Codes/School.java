package com.Codes;

import com.database.Sql;
import com.Main.Main_frame;
import com.database.DBconnect;
import static com.database.Sql.getCovered;
import static com.database.Sql.getCoveredt;
import com.home.CropImage;
import java.awt.Rectangle;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class School {
    public static final ImageIcon PROFIMAGE=new ImageIcon("src\\School Documents\\Images\\School Image.png");
    public static final ImageIcon PROFIMAGE_ROUND = new ImageIcon(new CropImage(PROFIMAGE.getImage(), new Rectangle(PROFIMAGE.getIconWidth() > PROFIMAGE.getIconHeight()
            ? (PROFIMAGE.getIconWidth() - PROFIMAGE.getIconHeight()) / 2 : 0,
            PROFIMAGE.getIconWidth() < PROFIMAGE.getIconHeight()
            ? (PROFIMAGE.getIconHeight() - PROFIMAGE.getIconWidth()) / 2 : 0,
            PROFIMAGE.getIconWidth() > PROFIMAGE.getIconHeight()
            ? PROFIMAGE.getIconHeight() : PROFIMAGE.getIconWidth(),
            PROFIMAGE.getIconWidth() > PROFIMAGE.getIconHeight()
            ? PROFIMAGE.getIconHeight() : PROFIMAGE.getIconWidth())).cropCircle());
    private static final Connection conn = DBconnect.CONN;
    public static final String Name = Sql.getValueS("SELECT "+getCoveredt("Name")+" FROM "+getCoveredt("schooldetails")+" WHERE Id=1", conn);
    public static final String Email = Sql.getValueS("SELECT "+getCoveredt("Email")+" FROM "+getCoveredt("schooldetails")+" WHERE Id=1", conn);
    public static final String Email_password = Sql.getValueS("SELECT "+getCoveredt("EmailPassword")+" FROM "+getCoveredt("schooldetails")+" WHERE Id=1", conn);
    public static final String Address = Sql.getValueS("SELECT "+getCoveredt("Address")+" FROM "+getCoveredt("schooldetails")+" WHERE Id=1", conn);
    public static final String district = Sql.getValueS("SELECT "+getCoveredt("district")+" FROM "+getCoveredt("schooldetails")+" WHERE Id=1", conn);
    public static final ImageIcon Badge = Sql.getImage("SELECT "+getCoveredt("Logo")+" FROM "+getCoveredt("schooldetails")+" WHERE Id=1", conn);
    public static final ImageIcon Image = Sql.getImage("SELECT "+getCoveredt("Image")+" FROM "+getCoveredt("schooldetails")+" WHERE Id=1", conn);
    public static final String Telephone = Sql.getValueS("SELECT "+getCoveredt("Telephone")+" FROM "+getCoveredt("schooldetails")+" WHERE Id=1", conn);

    public static Object[] getAll() {
        return new Object[]{Name, Address, Telephone, Image, Badge, Email, Email_password};
    }

    public static void setAll(String[] data) {
        try {
            Sql.insertData("INSERT INTO ", "SchoolDetails", data, conn);
        } catch (Exception ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getName() {
        return Name;
    }

    public void setName(String val) {
        Commons.setDefault("School_name", val, conn);
    }

    public static String getEmail() {
        return Email;
    }

    public static void setEmail(String val) {
        Commons.setDefault("School_email", val, conn);
    }

    public static String getEmail_password() {
        return Email_password;
    }

    public void setEmail_password(String val) {
        Commons.setDefault("School_email_password", val, conn);
    }

    public static String getAddress() {
        return Address;
    }

    public void setAddress(String val) {
        Commons.setDefault("School_address", val, conn);
    }

    public static ImageIcon getBadge() {
        return Badge;
    }

    public static void setBadge(String badge) {
        try {
            Sql.insertImage(conn.prepareStatement("UPDATE Images SET Image=? WHERE"+getCovered(Main_frame.ID_NO)+"='School_logo'"), badge);
        } catch (SQLException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setImage(String img) {
        try {
            Sql.insertImage(conn.prepareStatement("UPDATE Images SET Image=? WHERE"+getCovered(Main_frame.ID_NO)+"='School_image'"), img);
        } catch (SQLException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ImageIcon getImage() {
        return Image;
    }

    public static String getTelephone() {
        return Telephone;
    }

    public static void setTelephone(String val) {
        Commons.setDefault("School_phone", val, conn);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getAll()));
    }
}