package proje;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Personel extends JFrame {

	private static Personel frame;
	private JPanel contentPane;

	/**
	 * Frame oluþturuluyor
	 */
	public Personel() {
		setTitle("Personel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 220, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblhosgeldin = new JLabel(Giris.kullanici);
		lblhosgeldin.setHorizontalAlignment(SwingConstants.CENTER);
		lblhosgeldin.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		lblhosgeldin.setBounds(664, 74, 110, 32);
		contentPane.add(lblhosgeldin);
		
		JButton btnmaasgoruntule = new JButton(" Maa\u015F G\u00F6r\u00FCnt\u00FCle");
		btnmaasgoruntule.setIcon(new ImageIcon("icon\\maasgoruntule.png"));
		btnmaasgoruntule.setHorizontalAlignment(SwingConstants.LEFT);
		btnmaasgoruntule.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnmaasgoruntule.setBounds(10, 117, 421, 95);
		contentPane.add(btnmaasgoruntule);
		
		JButton btnGeri = new JButton(" Geri");
		btnGeri.setVisible(false);
		btnGeri.setIcon(new ImageIcon("icon\\gerii.png"));
		btnGeri.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnGeri.setBounds(0, 0, 160, 50);
		contentPane.add(btnGeri);
		
		JButton btncikis = new JButton(" \u00C7\u0131k\u0131\u015F");
		btncikis.addActionListener(new ActionListener() {//Çýkýþ iþlemleri
			public void actionPerformed(ActionEvent e) {
				Giris.frame=new Giris();
				Giris.frame.setVisible(true);
				if (Giris.frame2==null) {
					frame.dispose();
				} else {
					Giris.frame2.dispose();
				}
			}
		});
		btncikis.setIcon(new ImageIcon("icon\\cikis.png"));
		btncikis.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btncikis.setBounds(614, 500, 160, 50);
		contentPane.add(btncikis);
		
		JButton btnpersonelbilgileri = new JButton(" Personel Bilgileri");
		btnpersonelbilgileri.setIcon(new ImageIcon("icon\\personelbilgileri.png"));
		btnpersonelbilgileri.setHorizontalAlignment(SwingConstants.LEFT);
		btnpersonelbilgileri.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnpersonelbilgileri.setBounds(10, 11, 421, 95);
		contentPane.add(btnpersonelbilgileri);
		
		JLabel lblAdi = new JLabel("Ad\u0131n\u0131z:");
		lblAdi.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi.setVisible(false);
		lblAdi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdi.setBounds(0, 72, 177, 50);
		contentPane.add(lblAdi);
		
		JLabel lblSoyadi = new JLabel("Soyad\u0131n\u0131z:");
		lblSoyadi.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyadi.setVisible(false);
		lblSoyadi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoyadi.setBounds(0, 133, 177, 50);
		contentPane.add(lblSoyadi);
		
		JLabel lblBolum = new JLabel("B\u00F6l\u00FCm\u00FCn\u00FCz:");
		lblBolum.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblBolum.setVisible(false);
		lblBolum.setHorizontalAlignment(SwingConstants.LEFT);
		lblBolum.setBounds(0, 194, 177, 50);
		contentPane.add(lblBolum);
		
		JLabel lblMaas = new JLabel("Maaþýnýz:");
		lblMaas.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMaas.setVisible(false);
		lblMaas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaas.setBounds(0, 255, 177, 50);
		contentPane.add(lblMaas);
		
		JLabel lblVardiya = new JLabel("Vardiya:");
		lblVardiya.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblVardiya.setVisible(false);
		lblVardiya.setHorizontalAlignment(SwingConstants.RIGHT);
		lblVardiya.setBounds(0, 377, 177, 50);
		contentPane.add(lblVardiya);
		
		JLabel lblTarihAra = new JLabel("Tarih Arlk:");
		lblTarihAra.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblTarihAra.setVisible(false);
		lblTarihAra.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTarihAra.setBounds(0, 438, 177, 50);
		contentPane.add(lblTarihAra);
		
		JLabel lblMesai = new JLabel("Mesai:");
		lblMesai.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMesai.setVisible(false);
		lblMesai.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMesai.setBounds(0, 316, 177, 50);
		contentPane.add(lblMesai);
		
		JLabel lblAdi1 = new JLabel("");
		lblAdi1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi1.setVisible(false);
		lblAdi1.setForeground(new Color(255, 0, 0));
		lblAdi1.setBounds(179, 72, 250, 50);
		contentPane.add(lblAdi1);
		
		JLabel lblSoyadi1 = new JLabel("");
		lblSoyadi1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyadi1.setVisible(false);
		lblSoyadi1.setForeground(new Color(255, 0, 0));
		lblSoyadi1.setBounds(179, 133, 250, 50);
		contentPane.add(lblSoyadi1);
		
		JLabel lblBolum1 = new JLabel("");
		lblBolum1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblBolum1.setVisible(false);
		lblBolum1.setForeground(new Color(255, 0, 0));
		lblBolum1.setBounds(179, 194, 250, 50);
		contentPane.add(lblBolum1);
		
		JLabel lblMaas1 = new JLabel("");
		lblMaas1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMaas1.setVisible(false);
		lblMaas1.setForeground(new Color(255, 0, 0));
		lblMaas1.setBounds(179, 255, 250, 50);
		contentPane.add(lblMaas1);
		
		JLabel lblVardiya1 = new JLabel("");
		lblVardiya1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblVardiya1.setVisible(false);
		lblVardiya1.setForeground(new Color(255, 0, 0));
		lblVardiya1.setBounds(179, 377, 250, 50);
		contentPane.add(lblVardiya1);
		
		JLabel lblTarihAra1 = new JLabel("");
		lblTarihAra1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblTarihAra1.setVisible(false);
		lblTarihAra1.setForeground(new Color(255, 0, 0));
		lblTarihAra1.setBounds(179, 438, 450, 50);
		contentPane.add(lblTarihAra1);
		
		JLabel lblMesai1 = new JLabel("");
		lblMesai1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMesai1.setVisible(false);
		lblMesai1.setForeground(new Color(255, 0, 0));
		lblMesai1.setBounds(179, 316, 250, 50);
		contentPane.add(lblMesai1);
		
		JLabel lblHosÝcon = new JLabel("");
		lblHosÝcon.setIcon(new ImageIcon("icon\\personel.png"));
		lblHosÝcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHosÝcon.setBounds(664, 11, 110, 66);
		contentPane.add(lblHosÝcon);
		
		btnpersonelbilgileri.addActionListener(new ActionListener() {//Personel bilgiler ekraný iþlemleri
			public void actionPerformed(ActionEvent e) {
				btnpersonelbilgileri.setVisible(false);
				btnmaasgoruntule.setVisible(false);
				btnGeri.setVisible(true);
				lblAdi.setVisible(true);
				lblAdi1.setVisible(true);
				lblSoyadi.setVisible(true);
				lblSoyadi1.setVisible(true);
				lblBolum.setVisible(true);
				lblBolum1.setVisible(true);
				lblVardiya.setVisible(true);
				lblVardiya1.setVisible(true);
				lblMesai.setVisible(true);
				lblMesai1.setVisible(true);
				lblTarihAra.setVisible(true);
				lblTarihAra1.setVisible(true);
				try {//Giriþ yapan personelin bilgileri alýnýyor
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select * from Personel where Per_no='"+Giris.per_no+"'");
					lblAdi1.setText(rs.getString(2));
					lblSoyadi1.setText(rs.getString(3));
					lblBolum1.setText(rs.getString(5));
					lblVardiya1.setText(rs.getString(6));
					lblMesai1.setText(rs.getString(7));
					String tarihAra = null;
					if (rs.getString(8) != null&&rs.getString(9)!=null) {
						tarihAra=rs.getString(8)+" / "+rs.getString(9);
					}
					lblTarihAra1.setText(tarihAra);
					rs.close();
					Giris.conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnmaasgoruntule.addActionListener(new ActionListener() {//Maaþ Görüntüle ekraný iþlemleri
			public void actionPerformed(ActionEvent e) {
				btnmaasgoruntule.setVisible(false);
				btnpersonelbilgileri.setVisible(false);
				btnGeri.setVisible(true);
				lblAdi.setVisible(true);
				lblAdi1.setVisible(true);
				lblSoyadi.setVisible(true);
				lblSoyadi1.setVisible(true);
				lblMaas.setVisible(true);
				lblMaas1.setVisible(true);
				try {//Giriþ yapan personelin maaþ bilgisi alýnýyor
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select * from Personel where Per_no='"+Giris.per_no+"'");
					lblAdi1.setText(rs.getString(2));
					lblSoyadi1.setText(rs.getString(3));
					lblMaas1.setText(rs.getString(4));
					rs.close();
					Giris.conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		
		btnGeri.addActionListener(new ActionListener() {//AnaEkran
			public void actionPerformed(ActionEvent e) {
				btnpersonelbilgileri.setVisible(true);
				btnmaasgoruntule.setVisible(true);
				btnGeri.setVisible(false);
				lblAdi.setVisible(false);
				lblAdi1.setVisible(false);
				lblAdi1.setText("");
				lblSoyadi.setVisible(false);
				lblSoyadi1.setVisible(false);
				lblSoyadi1.setText("");
				lblBolum.setVisible(false);
				lblBolum1.setVisible(false);
				lblBolum1.setText("");
				lblVardiya.setVisible(false);
				lblVardiya1.setVisible(false);
				lblVardiya1.setText("");
				lblMesai.setVisible(false);
				lblMesai1.setVisible(false);
				lblMesai1.setText("");
				lblMaas.setVisible(false);
				lblMaas1.setVisible(false);
				lblMaas1.setText("");
				lblTarihAra.setVisible(false);
				lblTarihAra1.setVisible(false);
				lblTarihAra1.setText("");

			}
		});
	}
}
