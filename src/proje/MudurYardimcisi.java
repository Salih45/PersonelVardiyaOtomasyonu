package proje;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class MudurYardimcisi extends JFrame {

	private static MudurYardimcisi frame;
	private JPanel contentPane;
	private JTable tblPersonelBilgi;
	private DefaultTableModel model;
	private JTextField txtMesai;
	private JTextField txtAdi;
	private JTextField txtSoyad;
	private JComboBox<String> cmbxVardiya;
	private JComboBox<String> cmbxBolum;
	private JComboBox<String> cmbxPersonelNo;
	private int Perno;
	private JDateChooser dateIlk;
	private JDateChooser dateSon;


	/**
	 * Frame Oluþturuluyor
	 */
	public MudurYardimcisi() {
		setTitle("Müdür Yardýmcýsý");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 220, 238));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblhosgeldin = new JLabel(Giris.kullanici);
		lblhosgeldin.setHorizontalAlignment(SwingConstants.CENTER);
		lblhosgeldin.setBackground(Color.red);
		lblhosgeldin.setFont(new Font("Segoe Script", Font.PLAIN, 20));
		lblhosgeldin.setBounds(664, 31, 110, 32);
		contentPane.add(lblhosgeldin);
		
		JButton btnpersonelbilgileri = new JButton(" Personel Bilgileri");
		btnpersonelbilgileri.setHorizontalAlignment(SwingConstants.LEFT);
		btnpersonelbilgileri.setIcon(new ImageIcon("icon\\personelbilgileri.png"));
		btnpersonelbilgileri.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnpersonelbilgileri.setBounds(10, 11, 421, 95);
		contentPane.add(btnpersonelbilgileri);
		
		JButton btnvardiyamesaiata = new JButton(" Vardiya, Mesai Ata");
		btnvardiyamesaiata.setHorizontalAlignment(SwingConstants.LEFT);
		btnvardiyamesaiata.setIcon(new ImageIcon("icon\\vardiyamesaiata.png"));
		btnvardiyamesaiata.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnvardiyamesaiata.setBounds(10, 223, 421, 95);
		contentPane.add(btnvardiyamesaiata);
		
		JButton btnbolumata = new JButton(" B\u00F6l\u00FCm Ata");
		btnbolumata.setHorizontalAlignment(SwingConstants.LEFT);
		btnbolumata.setIcon(new ImageIcon("icon\\bolumata.png"));
		btnbolumata.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		btnbolumata.setBounds(10, 117, 421, 95);
		contentPane.add(btnbolumata);
		
		JButton btnGeri = new JButton(" Geri");
		btnGeri.setVisible(false);
		btnGeri.setIcon(new ImageIcon("icon\\gerii.png"));
		btnGeri.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btnGeri.setBounds(0, 0, 160, 50);
		contentPane.add(btnGeri);
		
		JLabel lblPersonel = new JLabel("Personel");
		lblPersonel.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblPersonel.setBounds(93, 99, 128, 50);
		lblPersonel.setVisible(false);
		contentPane.add(lblPersonel);
		
		cmbxPersonelNo = new JComboBox<String>();
		cmbxPersonelNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					if (cmbxPersonelNo.getSelectedIndex()>0) {
						String personel=(String) cmbxPersonelNo.getSelectedItem();
						String[] veri=personel.split(" ");
						Perno=Integer.valueOf(veri[0]);
						txtAdi.setText(veri[1]);
						txtSoyad.setText(veri[2]);
					} else {
						Perno=-1;
						txtAdi.setText("");
						txtSoyad.setText("");
					}
			}
		});
		cmbxPersonelNo.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		cmbxPersonelNo.setBounds(233, 99, 250, 50);
		cmbxPersonelNo.setVisible(false);
		contentPane.add(cmbxPersonelNo);
	
		JButton btnBolumAta = new JButton("B\u00F6l\u00FCm Ata");
		btnBolumAta.setIcon(new ImageIcon("icon\\bolumgir.png"));
		btnBolumAta.addActionListener(new ActionListener() {//Bölüm ekleme ve güncelleme iþlemleri
			public void actionPerformed(ActionEvent e) {
				try {
					Giris.conn=DriverManager.getConnection(Giris.url);
					java.sql.Statement st= Giris.conn.createStatement();
					if (cmbxBolum.getSelectedIndex()>0&&cmbxPersonelNo.getSelectedIndex()>0) {//Varsayýlan index mi secili kontrolü
						st.execute("UPDATE Personel set Per_bolum='"+cmbxBolum.getSelectedItem()+"'  where Per_no='"+Perno+"'");
						JOptionPane.showMessageDialog(null, Perno+"lu personelin bölüm atamasý Yapýldý");
					} else if(cmbxBolum.getSelectedIndex()==0&&cmbxPersonelNo.getSelectedIndex()==0) {
						JOptionPane.showMessageDialog(null, "Personel ve bölüm seçimi yapýnýz");
						
					} else if(cmbxPersonelNo.getSelectedIndex()==0) { 
						JOptionPane.showMessageDialog(null, "Personel Seçimi yapýnýz");
					} else {
						JOptionPane.showMessageDialog(null, "Bölüm seçimi yapýnýz");
					}
					Giris.conn.close();
					st.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Sorgu hatasý oluþtu.");	
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bir Sorun var :)");
				}
				
			}
		});
		btnBolumAta.setFont(new Font("Segoe Print", Font.PLAIN, 29));
		btnBolumAta.setBounds(233, 404, 250, 50);
		btnBolumAta.setVisible(false);
		contentPane.add(btnBolumAta);
		
		JLabel lblAdi = new JLabel("Ad\u0131");
		lblAdi.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi.setBounds(154, 225, 67, 50);
		lblAdi.setVisible(false);
		contentPane.add(lblAdi);
		
		
		txtAdi = new JTextField();
		txtAdi.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		txtAdi.setEnabled(false);
		txtAdi.setDisabledTextColor(Color.black);
		txtAdi.setColumns(10);
		txtAdi.setVisible(false);
		txtAdi.setBounds(233, 223, 250, 50);
		contentPane.add(txtAdi);
		
		JLabel lblSoyadi = new JLabel("Soyad\u0131");
		lblSoyadi.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyadi.setBounds(106, 288, 115, 50);
		lblSoyadi.setVisible(false);
		contentPane.add(lblSoyadi);
		
		txtSoyad = new JTextField();
		txtSoyad.setFont(new Font("Segoe Print", Font.PLAIN, 15));
		txtSoyad.setEnabled(false);
		txtSoyad.setDisabledTextColor(Color.black);
		txtSoyad.setColumns(10);
		txtSoyad.setBounds(233, 286, 250, 50);
		txtSoyad.setVisible(false);
		contentPane.add(txtSoyad);
		
		JButton btncikis = new JButton(" \u00C7\u0131k\u0131\u015F");
		btncikis.addActionListener(new ActionListener() {//Çýkýþ islemleri
				public void actionPerformed(ActionEvent e) {
					Giris.frame=new Giris();
					Giris.frame.setVisible(true);
					if (Giris.frame4==null) {
						frame.dispose();
					} else {
						Giris.frame4.dispose();
					}
				}
			});
		btncikis.setIcon(new ImageIcon("icon\\cikis.png"));
		btncikis.setFont(new Font("Segoe Print", Font.BOLD, 20));
		btncikis.setBounds(614, 500, 160, 50);
		contentPane.add(btncikis);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Segoe Print", Font.PLAIN, 12));
		scrollPane.setVisible(false);
		scrollPane.setBounds(83, 189, 634, 300);
		contentPane.add(scrollPane);
		
		tblPersonelBilgi = new JTable();
		tblPersonelBilgi.setAutoCreateRowSorter(true);//Sýralama yapmayý aktif yapma
		tblPersonelBilgi.getTableHeader().setReorderingAllowed(false);//Sutünlarýn yer deðiþtirme engelleme
		tblPersonelBilgi.setForeground(new Color(0, 0, 0));
		tblPersonelBilgi.setBackground(new Color(188, 235, 237));
		tblPersonelBilgi.setFont(new Font("Segoe Script", Font.PLAIN, 13));
		tblPersonelBilgi.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Ad", "Soyad", "B\u00F6l\u00FCm", "Vardiya", "Mesai", "Tarih Aral\u0131\u011F\u0131"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Object.class, Object.class, Object.class, Object.class, Integer.class, Object.class
			};//Veri tiplerini belirtme ve buna göre sýralama oluþturma yapmasý için
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			@Override
			public boolean isCellEditable(int row,int column) {//Bütün satýrlarýn düzenlemesini devre dýþý yapma
				return false;
			}
		} 
			
		
		);
		tblPersonelBilgi.getColumnModel().getColumn(0).setPreferredWidth(50);//Varsayýlan geniþlik düzenleme
		tblPersonelBilgi.getColumnModel().getColumn(1).setPreferredWidth(71);//Varsayýlan geniþlik düzenleme
		tblPersonelBilgi.getColumnModel().getColumn(2).setPreferredWidth(80);//Varsayýlan geniþlik düzenleme
		tblPersonelBilgi.getColumnModel().getColumn(3).setPreferredWidth(76);//Varsayýlan geniþlik düzenleme
		tblPersonelBilgi.getColumnModel().getColumn(4).setPreferredWidth(99);//Varsayýlan geniþlik düzenleme
		tblPersonelBilgi.getColumnModel().getColumn(5).setPreferredWidth(49);//Varsayýlan geniþlik düzenleme
		tblPersonelBilgi.getColumnModel().getColumn(6).setPreferredWidth(197);//Varsayýlan geniþlik düzenleme
		model=(DefaultTableModel) tblPersonelBilgi.getModel();
		tblPersonelBilgi.setVisible(false);
		scrollPane.setViewportView(tblPersonelBilgi);
		
		cmbxBolum = new JComboBox<String>();
		cmbxBolum.setFont(new Font("Segoe Print", Font.BOLD, 15));
		cmbxBolum.setModel(new DefaultComboBoxModel<String>(new String[] {"", "Depo", "\u00DCretim", "Teknik", "Temizlik"}));
		cmbxBolum.setVisible(false);
		cmbxBolum.setBounds(233, 349, 250, 50);
		contentPane.add(cmbxBolum);
		
		JLabel lblVardiya = new JLabel("Vardiya :");
		lblVardiya.setFont(new Font("Segoe Print", Font.PLAIN, 19));
		lblVardiya.setBounds(83, 135, 92, 50);
		lblVardiya.setVisible(false);
		contentPane.add(lblVardiya);
		
		JLabel lblMesai = new JLabel("Mesai :");
		lblMesai.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		lblMesai.setBounds(83, 74, 92, 50);
		lblMesai.setVisible(false);
		contentPane.add(lblMesai);
		
		cmbxVardiya = new JComboBox<String>();
		cmbxVardiya.setFont(new Font("Segoe Print", Font.BOLD, 15));
		cmbxVardiya.setModel(new DefaultComboBoxModel<String>(new String[] {"", "07:30/15:30", "15:30/23:30", "23:30/07:30"}));
		cmbxVardiya.setBounds(185, 137, 147, 50);
		cmbxVardiya.setVisible(false);
		contentPane.add(cmbxVardiya);
		
		txtMesai = new JTextField();
		txtMesai.setFont(new Font("Segoe Print", Font.BOLD, 15));
		txtMesai.setBounds(185, 74, 115, 50);
		txtMesai.setVisible(false);
		contentPane.add(txtMesai);
		txtMesai.setColumns(10);
		
		JButton btnVardiyaMesai = new JButton(" Ata");
		btnVardiyaMesai.setHorizontalAlignment(SwingConstants.LEFT);
		btnVardiyaMesai.setIcon(new ImageIcon("icon\\ata kopya.png"));
		btnVardiyaMesai.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		btnVardiyaMesai.addActionListener(new ActionListener() {//Vardiya mesai ve tarih aralýðý atama ve düzenleme iþlemleri
			public void actionPerformed(ActionEvent e) {
				try {
					Giris.conn=DriverManager.getConnection(Giris.url);
					java.sql.Statement st= Giris.conn.createStatement();
					if (!(txtMesai.getText().equals(""))&&cmbxVardiya.getSelectedIndex()>0) {//Boþ olma durumu ve varsayýlan indeks mi seçili
						try {
							Date Idate = dateIlk.getDate();//Girilen tarihler alýnýyor
							Date Sdate = dateSon.getDate();//Girilen tarihler alýnýyor
			                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); //kontrol edilecek tarih formatý  uymamasý durumda hata alýr 
							st.execute("UPDATE Personel set Per_vardiya='"+cmbxVardiya.getSelectedItem()+"', Per_mesai='"+txtMesai.getText()+"' ,Per_Itarih='"+dateFormat.format(Idate)+"',Per_Starih='"+ dateFormat.format(Sdate)+"'  where Per_no='"+tblPersonelBilgi.getValueAt(tblPersonelBilgi.getSelectedRow(), 0)+"'");
							JOptionPane.showMessageDialog(null, "Vardiya,mesai ve tarih aralýklarý güncellendi");
							yenile();
						} catch (SQLException e2) {
							JOptionPane.showMessageDialog(null, "Tarihi formata uygun giriniz(dd.MM.yyyy)");
						} catch (NullPointerException e2) {
							JOptionPane.showMessageDialog(null, "Tarihi formata uygun giriniz(dd.MM.yyyy)");
						}
						
					} else if (!txtMesai.getText().equals("")) {//Hangilerinin düzenleneceði kontrolleri 
						st.execute("UPDATE Personel set Per_mesai='"+txtMesai.getText()+"' where Per_no='"+tblPersonelBilgi.getValueAt(tblPersonelBilgi.getSelectedRow(), 0)+"'");
						JOptionPane.showMessageDialog(null, "Mesai Güncellendi");
					 
					} else if (cmbxVardiya.getSelectedIndex()>0) {
						try {
							Date Idate = dateIlk.getDate();
							Date Sdate = dateSon.getDate();
			                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");  
							st.execute("UPDATE Personel set Per_vardiya='"+cmbxVardiya.getSelectedItem()+"',Per_Itarih='"+dateFormat.format(Idate)+"',Per_Starih='"+ dateFormat.format(Sdate)+"'  where Per_no='"+tblPersonelBilgi.getValueAt(tblPersonelBilgi.getSelectedRow(), 0)+"'");
							JOptionPane.showMessageDialog(null, "Vardiya ve tarih aralýklarý güncellendi");
							yenile();
						} catch (SQLException e2) {
							JOptionPane.showMessageDialog(null, "Tarihi formata uygun giriniz(dd.MM.yyyy)");
						} catch (NullPointerException e2) {
							JOptionPane.showMessageDialog(null, "Tarihler boþ olamaz ve formata uygun olmalý(dd.MM.yyyy)");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Lüften gerekli alanlarý doldurunuz");
					}
				} catch (IndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(null, "Personel Seçiniz");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bir Sorun var :)");
				}
			}
		});
		btnVardiyaMesai.setBounds(542, 74, 175, 50);
		btnVardiyaMesai.setVisible(false);
		contentPane.add(btnVardiyaMesai);
		
		JLabel lblSaat = new JLabel("/s");
		lblSaat.setFont(new Font("Segoe Print", Font.BOLD, 18));
		lblSaat.setBounds(307, 74, 46, 49);
		lblSaat.setVisible(false);
		contentPane.add(lblSaat);
		
		JButton btnYenile = new JButton("Yenile");
		btnYenile.setHorizontalAlignment(SwingConstants.LEFT);
		btnYenile.setIcon(new ImageIcon("icon\\yenile.png"));
		btnYenile.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		btnYenile.addActionListener(new ActionListener() {//Listeleme güncel verileri alma
			public void actionPerformed(ActionEvent e) {
				yenile();
			}
		});
		btnYenile.setVisible(false);
		btnYenile.setBounds(542, 135, 175, 50);
		contentPane.add(btnYenile);
		
		JLabel lblAdi1 = new JLabel("Ad\u0131n\u0131z:");
		lblAdi1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi1.setVisible(false);
		lblAdi1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAdi1.setBounds(0, 72, 177, 50);
		contentPane.add(lblAdi1);
		
		JLabel lblSoyadi1 = new JLabel("Soyad\u0131n\u0131z:");
		lblSoyadi1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyadi1.setVisible(false);
		lblSoyadi1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSoyadi1.setBounds(0, 133, 177, 50);
		contentPane.add(lblSoyadi1);
		
		JLabel lblMaas1 = new JLabel("Maaþýnýz:");
		lblMaas1.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMaas1.setVisible(false);
		lblMaas1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaas1.setBounds(0, 255, 177, 50);
		contentPane.add(lblMaas1);
		
		JLabel lblAdi2 = new JLabel("");
		lblAdi2.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblAdi2.setVisible(false);
		lblAdi2.setForeground(new Color(255, 0, 0));
		lblAdi2.setBounds(179, 72, 250, 50);
		contentPane.add(lblAdi2);
		
		JLabel lblSoyadi2 = new JLabel("");
		lblSoyadi2.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblSoyadi2.setVisible(false);
		lblSoyadi2.setForeground(new Color(255, 0, 0));
		lblSoyadi2.setBounds(179, 133, 250, 50);
		contentPane.add(lblSoyadi2);
		
		JLabel lblMaas2 = new JLabel("");
		lblMaas2.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblMaas2.setVisible(false);
		lblMaas2.setForeground(new Color(255, 0, 0));
		lblMaas2.setBounds(179, 255, 250, 50);
		contentPane.add(lblMaas2);
		
		JLabel lblHosÝcon = new JLabel("");
		lblHosÝcon.setHorizontalAlignment(SwingConstants.CENTER);
		lblHosÝcon.setIcon(new ImageIcon("icon\\muduryar.png"));
		lblHosÝcon.setBounds(664, 11, 110, 24);
		contentPane.add(lblHosÝcon);
		
		Calendar tarih=Calendar.getInstance();
		
		dateIlk = new JDateChooser();
		dateIlk.setFont(new Font("Segoe Print", Font.BOLD, 12));
		
		dateIlk.setVisible(false);
		dateIlk.setDateFormatString("dd.MM.yyyy");
		dateIlk.setBounds(422, 74, 110, 50);
		contentPane.add(dateIlk);
		
		dateSon = new JDateChooser();
		dateSon.setFont(new Font("Segoe Print", Font.BOLD, 12));
		dateSon.setVisible(false);
		dateSon.setDateFormatString("dd.MM.yyyy");
		dateSon.setBounds(422, 135, 110, 50);
		contentPane.add(dateSon);
		
		JLabel lblSontar = new JLabel("Son Tarih");
		lblSontar.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lblSontar.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSontar.setVisible(false);
		lblSontar.setBounds(307, 135, 110, 50);
		contentPane.add(lblSontar);
		
		JLabel lbllkTar = new JLabel("\u0130lk Tarih");
		lbllkTar.setFont(new Font("Segoe Print", Font.BOLD, 15));
		lbllkTar.setHorizontalAlignment(SwingConstants.RIGHT);
		lbllkTar.setVisible(false);
		lbllkTar.setBounds(310, 74, 110, 50);
		contentPane.add(lbllkTar);
		
		JLabel lblBolum = new JLabel("B\u00F6l\u00FCm\u00FC");
		lblBolum.setHorizontalAlignment(SwingConstants.LEFT);
		lblBolum.setFont(new Font("Segoe Print", Font.PLAIN, 30));
		lblBolum.setVisible(false);
		lblBolum.setBounds(106, 349, 250, 50);
		contentPane.add(lblBolum);
		
		lblhosgeldin.addMouseListener(new MouseAdapter() {//Kullanýcý personel bilgileri iþlemleri
			@Override
			public void mouseEntered(MouseEvent e) {//üstüne gelindiðinde iþlemleri
				Color c=lblhosgeldin.getBackground();
				lblhosgeldin.setBackground(lblhosgeldin.getForeground());
				lblhosgeldin.setForeground(c);
			}
			public void mouseExited(MouseEvent e) {//üstünden ayrýldýðýnda iþlemleri
				Color c=lblhosgeldin.getForeground();
				lblhosgeldin.setForeground(lblhosgeldin.getBackground());
				lblhosgeldin.setBackground(c);
			}
			@Override
			public void mouseClicked(MouseEvent e) {//Týklanma olayýnda iþlemleri
				btnbolumata.setVisible(false);
				btnpersonelbilgileri.setVisible(false);
				btnvardiyamesaiata.setVisible(false);
				scrollPane.setVisible(false);
				int tblSz=model.getRowCount();
				for (int i = 0; i < tblSz; i++) {
					model.removeRow(0);
				}
				btnBolumAta.setVisible(false);
				btnYenile.setVisible(false);
				lblPersonel.setVisible(false);
				cmbxPersonelNo.setVisible(false);
				cmbxBolum.setVisible(false);
				btnVardiyaMesai.setVisible(false);
				scrollPane.setVisible(false);
				lblMesai.setVisible(false);
				lblVardiya.setVisible(false);
				lblSaat.setVisible(false);
				txtMesai.setVisible(false);
				cmbxVardiya.setVisible(false);
				lblAdi.setVisible(false);
				lblSoyadi.setVisible(false);
				txtAdi.setVisible(false);
				txtSoyad.setVisible(false);
				btnGeri.setVisible(true);
				lblAdi1.setVisible(true);
				lblAdi2.setVisible(true);
				lblSoyadi1.setVisible(true);
				lblSoyadi2.setVisible(true);
				lblMaas1.setVisible(true);
				lblMaas2.setVisible(true);
				lbllkTar.setVisible(false);
				lblSontar.setVisible(false);
				lblBolum.setVisible(false);
				dateIlk.setVisible(false);
				dateSon.setVisible(false);
				try {//Giris yapan personelin bilgileri alýnýyor
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select Per_ad,Per_soyad,Per_maas from Personel where Per_no='"+Giris.per_no+"'");
					lblAdi2.setText(rs.getString(1));
					lblSoyadi2.setText(rs.getString(2));
					lblMaas2.setText(rs.getString(3));
					rs.close();
					Giris.conn.close();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Sorgu Hatasý");
				}
			}
		});
		
		btnbolumata.addActionListener(new ActionListener() {//Bölüm atama ekraný iþlemleri
			public void actionPerformed(ActionEvent e) {
				btnbolumata.setVisible(false);
				btnpersonelbilgileri.setVisible(false);
				btnvardiyamesaiata.setVisible(false);
				btnGeri.setVisible(true);
				btnBolumAta.setVisible(true);
				lblPersonel.setVisible(true);
				lblAdi.setVisible(true);
				lblSoyadi.setVisible(true);
				lblBolum.setVisible(true);
				txtAdi.setVisible(true);
				txtSoyad.setVisible(true);
				cmbxPersonelNo.setVisible(true);
				cmbxBolum.setVisible(true);
				cmbxPersonelNo.removeAllItems();
				try {
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st=Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select p.Per_no,Per_ad,Per_soyad,Yetki from Personel as p LEFT JOIN KlncHesaplari as klnc ON klnc.Per_no=p.Per_no");
					cmbxPersonelNo.addItem("");
					while (rs.next()) {
						if (rs.getString(4)==null) {
							
						} else {
							if (rs.getString(4).equals("Müdür")||rs.getString(4).equals("Müdür Yardýmcýsý")) {
								
							} else {
								cmbxPersonelNo.addItem(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
							}
						}
						
						
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Sorgu Hatasý");
				}
				
			}
		});
		
		btnpersonelbilgileri.addActionListener(new ActionListener() {//Personel bilgileri ekraný iþlemleri
			public void actionPerformed(ActionEvent e) {
				btnbolumata.setVisible(false);
				btnpersonelbilgileri.setVisible(false);
				btnvardiyamesaiata.setVisible(false);
				btnGeri.setVisible(true);
				scrollPane.setVisible(true);
				tblPersonelBilgi.setVisible(true);
				try {//Personel verileri alma iþlemleri
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st= Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select p.Per_no,Per_ad,p.Per_soyad,Per_bolum,Per_vardiya,Per_mesai,Per_Itarih,Per_Starih from Personel as p INNER JOIN KlncHesaplari as klnc ON p.Per_no = klnc.Per_no WHERE klnc.Yetki='Personel' OR klnc.Yetki='Usta' order by p.Per_no ");
					while (rs.next()) {//verilerin jtableye eklenmesi
						Integer mesai = null;
						if (rs.getInt(6)!=0) {
							mesai=rs.getInt(6);
						}						
						String tarihAra = null;
						if (rs.getString(7) != null&&rs.getString(8)!=null) {
							tarihAra=rs.getString(7)+" / "+rs.getString(8);
						}
						model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),mesai,tarihAra});
					}
					Giris.conn.close();
					st.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bir sorun var :)");
				}
			}
		});
		
		btnvardiyamesaiata.addActionListener(new ActionListener() {//Vardiya , Mesai ve Tarih aralýðý ekraný iþlemleri
			public void actionPerformed(ActionEvent e) {
				btnbolumata.setVisible(false);
				btnpersonelbilgileri.setVisible(false);
				btnvardiyamesaiata.setVisible(false);
				btnGeri.setVisible(true);
				btnVardiyaMesai.setVisible(true);
				btnYenile.setVisible(true);
				scrollPane.setVisible(true);
				tblPersonelBilgi.setVisible(true);
				lblMesai.setVisible(true);
				lblVardiya.setVisible(true);
				lblSaat.setVisible(true);
				lbllkTar.setVisible(true);
				lblSontar.setVisible(true);
				txtMesai.setVisible(true);
				cmbxVardiya.setVisible(true);
				dateIlk.setVisible(true);
				dateSon.setVisible(true);
				tarih.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);//Þuanki sistem tarihinin pazartesi günü alýnýyor
				dateIlk.setDate(tarih.getTime());
				tarih.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);//Þuanki sistem tarihinin cumartesi günü alýnýyor
				dateSon.setDate(tarih.getTime());
				try {//Personel verileri alma iþlemleri
					Giris.conn=DriverManager.getConnection(Giris.url);
					Statement st= Giris.conn.createStatement();
					ResultSet rs=st.executeQuery("select p.Per_no,Per_ad,p.Per_soyad,Per_bolum,Per_vardiya,Per_mesai,Per_Itarih,Per_Starih from Personel as p INNER JOIN KlncHesaplari as klnc ON p.Per_no = klnc.Per_no WHERE klnc.Yetki='Personel' OR klnc.Yetki='Usta' order by p.Per_no");
					while (rs.next()) {//Personel bilgileri jtableye aktarýlýyor
						Integer mesai = null;
						if (rs.getInt(6)!=0) {
							mesai=rs.getInt(6);
						}
						String tarihAra = null;
						if (rs.getString(7) != null&&rs.getString(8)!=null) {
							tarihAra=rs.getString(7)+" / "+rs.getString(8);
						}
						model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),mesai,tarihAra});
					}
					Giris.conn.close();
					st.close();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Bir sorun var :)");
				}
			}
		});

		
		btnGeri.addActionListener(new ActionListener() {//AnaEkran
			public void actionPerformed(ActionEvent e) {
				btnbolumata.setVisible(true);
				btnpersonelbilgileri.setVisible(true);
				btnvardiyamesaiata.setVisible(true);
				btnGeri.setVisible(false);
				scrollPane.setVisible(false);
				int tblSz=model.getRowCount();
				for (int i = 0; i < tblSz; i++) {
					model.removeRow(0);//Tablo verilerinin silinmesi
				}
				btnBolumAta.setVisible(false);
				btnYenile.setVisible(false);
				lblPersonel.setVisible(false);
				cmbxPersonelNo.setVisible(false);
				cmbxBolum.setVisible(false);
				btnVardiyaMesai.setVisible(false);
				scrollPane.setVisible(false);
				lblMesai.setVisible(false);
				lblVardiya.setVisible(false);
				lblSaat.setVisible(false);
				txtMesai.setVisible(false);
				cmbxVardiya.setVisible(false);
				lblAdi1.setVisible(false);
				lblAdi2.setVisible(false);
				lblAdi2.setText("");
				lblSoyadi1.setVisible(false);
				lblSoyadi2.setVisible(false);
				lblSoyadi2.setText("");
				lblMaas1.setVisible(false);
				lblMaas2.setVisible(false);
				lblMaas2.setText("");
				lbllkTar.setVisible(false);
				lblSontar.setVisible(false);
				lblBolum.setVisible(false);
				lblAdi.setVisible(false);
				lblSoyadi.setVisible(false);
				txtAdi.setVisible(false);
				txtSoyad.setVisible(false);
				dateIlk.setVisible(false);
				dateSon.setVisible(false);
				
			}
		});
	}
	private void yenile() {
		try {
			Giris.conn=DriverManager.getConnection(Giris.url);
			Statement st= Giris.conn.createStatement();
			ResultSet rs=st.executeQuery("select p.Per_no,Per_ad,p.Per_soyad,Per_bolum,Per_vardiya,Per_mesai,Per_Itarih,Per_Starih from Personel as p INNER JOIN KlncHesaplari as klnc ON p.Per_no = klnc.Per_no WHERE klnc.Yetki='Personel' OR klnc.Yetki='Usta' order by p.Per_no");
			int tblSz=model.getRowCount();
			for (int i = 0; i < tblSz; i++) {
				model.removeRow(0);//Eski verilerin kaldýrýlmasý
			}
			while (rs.next()) {//Yeni veriler alýnýyor
				Integer mesai=null;
				if (rs.getInt(6)!=0) {
					mesai=rs.getInt(6);
				}						
				String tarihAra = null;
				if (rs.getString(7) != null&&rs.getString(8)!=null) {
					tarihAra=rs.getString(7)+" / "+rs.getString(8);
				}
				model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),mesai,tarihAra});
			}
			Giris.conn.close();
			st.close();
			rs.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}
