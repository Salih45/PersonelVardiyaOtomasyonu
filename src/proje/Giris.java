package proje;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import java.awt.Color;

public class Giris extends JFrame {
	
	protected static Connection conn=null;
	protected static String url="jdbc:sqlite:Veritabani/PersonelVardiyaOtomasyonu.db";//Veritaban� Dosya Yolu
	private JPanel contentPane;
	private JTextField txtkullaniciadi;
	private JPasswordField txtsifre;
	private JButton btngiris;
	public static Giris frame;
	public static Mudur frame1;
	public static Personel frame2;
	public static Usta frame3;
	public static MudurYardimcisi frame4;
	public static String kullanici;
	public static int per_no;
	

	/**
	 * Uygulama Ba�l�yor
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				frame = new Giris();
				frame.setVisible(true);
				
			}
		});
	}
	/**
	 * Frame Olu�turuluyor
	 */
	public  Giris() {
		setTitle("Giri�");//Pencereye ba�l�k verildi	
		try { //Hata yakalama
			conn=DriverManager.getConnection(url);//Veritaban�na ba�lant� yap�l�yor
			System.out.println("Veriban�na Ba�lant� Sa�land�");
			
			try {
				Statement st= conn.createStatement();
				ResultSet rs= st.executeQuery("select * from klncHesaplari");//Veriler okundu
				
				while (rs.next()) {
					System.out.println(rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));//Veriler ekrana yazd�r�l�yor	
				}
				conn.close();
				rs.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 450);//Frame Boyutu Belirlendi
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtkullaniciadi = new JTextField();
		txtkullaniciadi.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		txtkullaniciadi.setBounds(287, 22, 421, 95);
		txtkullaniciadi.addKeyListener(new KeyAdapter() {//txtfield bo� olup olmad��� kontrol
			@Override
			public void keyReleased(KeyEvent e) {// Tu� Sal�nd���nda
				if (txtkullaniciadi.getText().isEmpty()||String.valueOf(txtsifre.getPassword()).isEmpty()) {//Bo� Oldu�unda
					btngiris.setEnabled(false);
				} else {
					btngiris.setEnabled(true);
				}
			}
		});
		contentPane.setLayout(null);
		contentPane.add(txtkullaniciadi);
		
		JLabel lblSifre = new JLabel("         \u015Eifre");
		lblSifre.setHorizontalAlignment(SwingConstants.LEFT);
		lblSifre.setIcon(new ImageIcon("icon\\sifre.png"));
		lblSifre.setBounds(10, 140, 267, 95);
		lblSifre.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		contentPane.add(lblSifre);
		
		txtsifre = new JPasswordField();
		txtsifre.setFont(new Font("Segoe Print", Font.PLAIN, 29));
		txtsifre.setBounds(287, 140, 421, 95);
		txtsifre.addKeyListener(new KeyAdapter() {//txtfield bo� olup olmad��� kontrol
			@Override
			public void keyReleased(KeyEvent e) {//Tu� Sal�nd���nda
				if (txtkullaniciadi.getText().isEmpty()||String.valueOf(txtsifre.getPassword()).isEmpty()) {//Bo� oldu�unda
					btngiris.setEnabled(false);//Pasif
				} else {
					btngiris.setEnabled(true);//Aktif
				}
			}
		});
		contentPane.add(txtsifre);
		JLabel lblNewLabel = new JLabel("Kullan�c� Ad�");
		lblNewLabel.setIcon(new ImageIcon("icon\\kullanici.png"));
		lblNewLabel.setBounds(10, 22, 278, 95);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		contentPane.add(lblNewLabel); 
		
		btngiris = new JButton(" Giri\u015F");
		btngiris.setBackground(new Color(175, 238, 238));
		btngiris.setIcon(new ImageIcon("icon\\giris.png"));
		btngiris.setBounds(287, 258, 421, 95);
		btngiris.setFont(new Font("Segoe Print", Font.BOLD, 40));//�al��t���nda txtfieldlerin bo� olup olmaas� kontrl�
		if (!(txtkullaniciadi.getText().isEmpty()&& String.valueOf(txtsifre.getPassword()).isEmpty())) {
			btngiris.setEnabled(true);
		} else {
			btngiris.setEnabled(false);
		}
		contentPane.add(btngiris);
		btngiris.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				//Yetki Ve giri� kontrol� yap�l�yor
				ResultSet rs;
				try {
					conn=DriverManager.getConnection(url);
					Statement st= conn.createStatement();
					rs = st.executeQuery("select count(KulAd) from KlncHesaplari");//Db uzunluks
					int dbuznlk=rs.getInt(1);
					rs = st.executeQuery("select * from klncHesaplari");
					int donus=0;
					while (rs.next()) {
						donus++;
						if (txtkullaniciadi.getText().equals(rs.getString(3))&&String.valueOf(txtsifre.getPassword()).equals(rs.getString(4))) {
							if (rs.getString(2).equals("M�d�r")) {// Yetki y�nlendirmesi
								kullanici=rs.getString(3);
								per_no=rs.getInt(1);
								frame1=new Mudur();
								frame1.setVisible(true);	
								frame.dispose();
								break;
							}
							else if(rs.getString(2).equals("Usta")){// Yetki y�nlendirmesi
								kullanici=rs.getString(3);
								per_no=rs.getInt(1);
								frame3=new Usta();
								frame3.setVisible(true);	
								frame.dispose();
								break;
							}
							else if(rs.getString(2).equals("M�d�r Yard�mc�s�")){// Yetki y�nlendirmesi
								kullanici=rs.getString(3);
								per_no=rs.getInt(1);
								frame4=new MudurYardimcisi();
								frame4.setVisible(true);	
								frame.dispose();
								break;
							}
							else {
								kullanici=rs.getString(3);
								per_no=rs.getInt(1);
								frame2=new Personel();// Yetki y�nlendirmesi
								frame2.setVisible(true);	
								frame.dispose();
								break;
							}
						}
						else if (dbuznlk<=donus) {
							JOptionPane.showMessageDialog(null,"Bilgiler Yanl��!!!");
						}
					}
					conn.close();
					rs.close();
				} catch (SQLException e1) {
					System.out.println("VeriTaban�na Ba�lan�lamad�...!!!");
					e1.printStackTrace();
				}
				
			}
		});
	}
	
}
