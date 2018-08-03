import java.awt.*;
import java.util.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;
class MyMenues extends Frame implements ActionListener
{
    private Menu file,Edit,format,View,Help;
    private MenuBar mb=new MenuBar();
    private MenuItem New,Open,Save,Save_as,page_setup,print,exit,undo,redo,cut,copy,paste,delete,find,find_next,replace,goto_,time_date,fontwrap,font_,statusbar,view_help,about_notpad;                                          
    private TextArea txta_show;    
    private String msg="";
	Clipboard clip = getToolkit().getSystemClipboard();
    public MyMenues()
    {
        
        setTitle("Notepad");
        setSize(500,500);
        setLocation(100,100);        
        /*----------------file----------------*/
        New=new MenuItem("New");
        
        Open=new MenuItem("Open");
        Save=new MenuItem("Save");
        Save_as=new MenuItem("Save As");
        page_setup=new MenuItem("Page Setup");
        print=new MenuItem("Print");
        exit=new MenuItem("Exit");
        
        file=new Menu("File");
    
        file.add(New);
        file.add(Open);
        file.add(Save);
        file.add(Save_as);
        file.addSeparator();
        file.add(page_setup);
        file.add(print);
        file.addSeparator();
        file.add(exit);
        
        mb.add(file);        
        /*-------------Edit--------------*/
        undo=new MenuItem("Undo");
        redo=new MenuItem("Redo");
        cut=new MenuItem("Cut");
        copy=new MenuItem("Copy");
        paste=new MenuItem("Paste");
        delete=new MenuItem("Delete");
        find=new MenuItem("Find");
        find_next=new MenuItem("Find Next");
        replace=new MenuItem("Replace");
        goto_=new MenuItem("Goto");
        time_date=new MenuItem("Time/Date");
        
        Edit=new Menu("Edit");    
                
//        Edit.add(undo);
//        Edit.add(redo);
        Edit.addSeparator();
        Edit.add(cut);
        Edit.add(copy);
        Edit.add(paste);
        Edit.add(delete);
        Edit.addSeparator();
        Edit.add(find);
        Edit.add(replace);
//        Edit.add(goto_);
        Edit.addSeparator();
        Edit.add(time_date);
        
        mb.add(Edit);        
        /*--------------format------------------*/        
        fontwrap=new MenuItem("Font Wrap");
        font_=new MenuItem("Font");
                
        format=new Menu("Format");
        
        format.add(fontwrap);
        format.add(font_);
        
        mb.add(format);        
        /*------------------view-----------------*/        
        statusbar=new MenuItem("StatusBar");
        
        View=new Menu("View");
        
        View.add(statusbar);
        
        mb.add(View);
                
        /*-----------------help-----------------*/        
        view_help=new MenuItem("View Help");
        about_notpad=new MenuItem("About Notepad");
        
        Help=new Menu("Help");
        
        Help.add(view_help);
        Help.addSeparator();
        Help.add(about_notpad);
        
        mb.add(Help);        
        /*-------------------textarea--------------------*/        
        txta_show=new TextArea();
        add(txta_show);
        
        setMenuBar(mb);
        /*-------------------------------------*/
        
        
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
                
            }
        });
        /*---------------addactionlistener------------------*/
        New.addActionListener(this);
        Open.addActionListener(this);
        Save.addActionListener(this);
        Save_as.addActionListener(this);
        page_setup.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        undo.addActionListener(this);
        redo.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        delete.addActionListener(this);
        find.addActionListener(this);
        find_next.addActionListener(this);
        replace.addActionListener(this);
        goto_.addActionListener(this);
        time_date.addActionListener(this);
        fontwrap.addActionListener(this);
        font_.addActionListener(this);
        statusbar.addActionListener(this);
        view_help.addActionListener(this);
        about_notpad.addActionListener(this);                                             
    }
	class Find extends Frame implements ActionListener
	{
    //Variables declaration
    TextArea tax;
    TextField te1, te2;
    Label la1, la2;
    Button bu1, bu2, bu3, bu4;
    int startindex, ln, i;
    public Find()//(String title)
    {
    //    super(title);
        setLocation(200,200);
		i=startindex=ln=0;
        tax=new TextArea(10,50);
        te1=new TextField(10);
        te2=new TextField(10);
        la1=new Label("Find What:");
        la2=new Label("Replace With:");
        bu1=new Button("Find");
        bu2=new Button("Replace");
        bu3=new Button("Replace All");
        bu4=new Button("Cancel");
        setLayout(new FlowLayout());
        bu1.addActionListener(this);
        bu2.addActionListener(this);
        bu3.addActionListener(this);
        bu4.addActionListener(this);
        //add(tax);
        add(la1);
        add(te1);
        add(la2);
        add(te2);
        add(bu1);
        add(bu2);
        //add(bu3);
        add(bu4);
		addWindowListener(new WindowAdapter()
    {
		public void windowClosing(WindowEvent we)
        {
            //System.exit(0);
            dispose();    
        }
    });
    
    }
	
    public void actionPerformed(ActionEvent e)
    {
        String findwhat=new String("");
        String replacewith=new String("");
        String text=txta_show.getText();
        findwhat=te1.getText();
        ln=findwhat.length();
        replacewith=te2.getText();
		
        if(e.getSource()==bu1)//Decision making statement
        {
            startindex=text.indexOf(findwhat,i);
            txta_show.select(startindex,startindex+ln);
            i=startindex+ln;
        }
        else if(e.getSource()==bu2)
		{
			startindex=(text.indexOf(findwhat,i))-1;
            txta_show.select(startindex,startindex+ln);
            i=startindex+ln;
			txta_show.replaceRange(replacewith,startindex,startindex+ln);
        /*else if(e.getSource()==bu3)
        {
            //For statement
            for(int i=0;i<text.length();i=startindex+ln )
                 {
                startindex=text.indexOf(findwhat,i);
        txta_show.replaceRange(replacewith,startindex,startindex+ln);
            }
        }*/}
		else if(e.getSource()==bu4)
			dispose();
    
    }
	
	}
	class MyDialog2 extends  Dialog implements  ActionListener
{
	int day, month, year;
      int second, minute, hour;
      GregorianCalendar date = new GregorianCalendar();
 
      
    private Label lbl_msg,lbl_msg2;
    private Button btn_yes,btn_no;
    private Panel north_panel,south_panel;
    public MyDialog2()
    {
        super(new MyMenues(),"Dialog Demo",true);
        day = date.get(Calendar.DAY_OF_MONTH);
      month = date.get(Calendar.MONTH);
      year = date.get(Calendar.YEAR);
 
      second = date.get(Calendar.SECOND);
      minute = date.get(Calendar.MINUTE);
      hour = date.get(Calendar.HOUR);
 
		north_panel=new Panel();
        south_panel=new Panel();
        
        setTitle("Date and Time");
        setSize(400,200);
        setLocation(50,80);
        lbl_msg=new Label("Current date is  "+day+"/"+(month+1)+"/"+year+"\nCurrent time is  "+hour+" : "+minute+" : "+second);
        btn_yes=new Button("OK");
        
        north_panel.add(lbl_msg);
        south_panel.add(btn_yes);
        add(south_panel,"South");
        add(north_panel,"North");
        btn_yes.addActionListener(this);
		addWindowListener(new WindowAdapter()
    {
		public void windowClosing(WindowEvent we)
        {
            //System.exit(0);
            dispose();    
        }
    });
	}
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btn_yes)
            dispose();
    }
	
}

      
    public void actionPerformed(ActionEvent ae)
    {
		if(ae.getSource()==find || ae.getSource()==replace)
		{
			Find fi=new Find();
			fi.setSize(200,200);	
			fi.show();
		}
        /*---------------file menu----------------------*/
        if(ae.getSource()==view_help)
		{
			new MyDialog1().setVisible(true);
		}
		if(ae.getSource()==time_date)
			new MyDialog2().setVisible(true);
		if(ae.getSource()==New)
        {
            txta_show.setText(" ");
        }
        else if(ae.getSource()==Open)
        {
            try
            {
                FileDialog fd=new FileDialog(this,"Open File",FileDialog.LOAD);
                fd.setVisible(true);
                String dir=fd.getDirectory();
                String fname=fd.getFile();
                FileInputStream fis=new FileInputStream(dir+fname);
                DataInputStream dis=new DataInputStream(fis);
                String str=" ",msg=" ";
                while((str=dis.readLine())!=null)
                {
                    msg=msg+str;
                    msg+="\n";
                }
                txta_show.setText(msg);
                dis.close();
            }
            catch(Exception e){}
        }
        else if(ae.getSource()==Save)
        {
            try
            {
                FileDialog fd=new FileDialog(this,"Save File",FileDialog.SAVE);
                fd.setVisible(true);
                String txt=txta_show.getText();
                String dir=fd.getDirectory();
                String fname=fd.getFile();
                FileOutputStream fos=new FileOutputStream(dir+fname);
                DataOutputStream dos=new DataOutputStream(fos);
                dos.writeBytes(txt);
                dos.close();
            }
            catch(Exception e)
            {
            }
        }
		else if(ae.getSource()==Save_as)
        {
            try
            {
                FileDialog fd=new FileDialog(this,"Save As File",FileDialog.SAVE);
                fd.setVisible(true);
                String txt=txta_show.getText();
                String dir=fd.getDirectory();
                String fname=fd.getFile();
                FileOutputStream fos=new FileOutputStream(dir+fname);
                DataOutputStream dos=new DataOutputStream(fos);
                dos.writeBytes(txt);
                dos.close();
            }
            catch(Exception e)
            {
            }
        }
        else if(ae.getSource()==exit)
        {
            new Exit_Window().setVisible(true);
        }
        /*------------------Edit Menu---------------------------*/
        else if(ae.getSource()==cut)
        {
            /*msg=txta_show.getSelectedText();
            txta_show.replaceRange("",txta_show.getSelectionStart(),txta_show.getSelectionEnd());
        */
			String sel = txta_show.getSelectedText();
             StringSelection ss = new StringSelection(sel);
             clip.setContents(ss,ss);
             txta_show.replaceRange(" ",txta_show.getSelectionStart(),txta_show.getSelectionEnd());

		}
        else if(ae.getSource()==copy)
        {
			String sel = txta_show.getSelectedText();
             StringSelection clipString = new StringSelection(sel);
             clip.setContents(clipString,clipString);//msg=txta_show.getSelectedText();
        }
        else if(ae.getSource()==paste)
        {
//            txta_show.replaceRange("",txta_show.getSelectionStart(),txta_show.getSelectionEnd());
	
			Transferable cliptran = clip.getContents(this);
             try
                 {
                 String sel = (String) cliptran.getTransferData(DataFlavor.stringFlavor);
                 txta_show.replaceRange(sel,txta_show.getSelectionStart(),txta_show.getSelectionEnd());
             }
             catch(Exception exc)
                 {
                 System.out.println("not string flavour");
             }
		}
        else if(ae.getSource()==replace)
        {
        //    new replaceBox().setVisible(true);
        }
        /*-----------------------Help Menu------------------------------*/
        else if(ae.getSource()==about_notpad)
        {
            new MyDialog().setVisible(true);    
        }        
    }
}
class Exit_Window extends Dialog implements ActionListener
{
    private Label lbl_show_msg;
    private Button btn_yes,btn_no;
    public Exit_Window()
    {
        super(new MyMenues(),"Exit",true);
        setLayout(new FlowLayout());        
        
        lbl_show_msg=new Label("Are you want to exit ??");
        add(lbl_show_msg);
        
        btn_yes=new Button("Yes");
        btn_yes.addActionListener(this);
        add(btn_yes);
        
        btn_no=new Button("No");
        btn_no.addActionListener(this);
        add(btn_no);
        
        setTitle("Exit Window");
        setSize(150,100);
        setLocation(200,200);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btn_yes)
        {
            System.exit(0);
        }
        else
            dispose();    
    }
}
/*
class replaceBox extends Dialog implements ActionListener
{
    private Label lbl_replace,lbl_replacewith;
    private TextField txt_replace,txt_replacewith;
    private Button btn_change,btn_close;
    public replaceBox()
    {
        setLayout(null);
        
        lbl_replace=new Label("Replace");
        lbl_replace.setBounds(50,50,100,30);
        add(lbl_replace);
        
        txt_replace=new TextField();
        txt_replace.setBounds(100,50,100,30);
        add(txt_replace);
        
        lbl_replacewith=new Label("ReplaceWith");
        lbl_replacewith.setBounds(50,100,100,30);
        add(lbl_replacewith);
        
        txt_replacewith=new TextField();
        txt_replacewith.setBounds(100,100,100,30);
        add(txt_replacewith);
        
        btn_change=new Button("Change");
        btn_change.setBounds(50,150,50,30);
        add(btn_change);
        
        btn_close=new Button("Close");
        btn_close.setBounds(75,150,125,30);
        add(btn_close);
        
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent we)
            {
                System.exit(0);
                
            }
        });
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btn_change)
        {
                
        }
    }
}*/
class MyDialog extends  Dialog implements  ActionListener
{
    private Label lbl_msg;
    private Button btn_yes,btn_no;
    private Panel north_panel,south_panel;
    public MyDialog()
    {
        super(new MyMenues(),"Dialog Demo",true);
        north_panel=new Panel();
        south_panel=new Panel();
        
        setTitle("Notepad Information");
        setSize(400,200);
        setLocation(50,80);
        lbl_msg=new Label("This is a Basic Text Editor");
        btn_yes=new Button("Yes");
        
        north_panel.add(lbl_msg);
        south_panel.add(btn_yes);
        add(south_panel,"South");
        add(north_panel,"North");
        btn_yes.addActionListener(this);
		addWindowListener(new WindowAdapter()
    {
		public void windowClosing(WindowEvent we)
        {
            //System.exit(0);
            dispose();    
        }
    });
	}
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btn_yes)
            dispose();
    }
	
}

class MyDialog1 extends  Dialog implements  ActionListener
{
    private Label lbl_msg;
    private Button btn_yes,btn_no;
    private Panel north_panel,south_panel;
    public MyDialog1()
    {
        super(new MyMenues(),"Dialog Demo",true);
        north_panel=new Panel();
        south_panel=new Panel();
        
        setTitle("Notepad Help");
        setSize(400,200);
        setLocation(50,80);
        lbl_msg=new Label("Yo! Help Yourself!!");
        btn_yes=new Button("OK");
        
        north_panel.add(lbl_msg);
        south_panel.add(btn_yes);
        add(south_panel,"South");
        add(north_panel,"North");
        btn_yes.addActionListener(this);
		addWindowListener(new WindowAdapter()
    {
		public void windowClosing(WindowEvent we)
        {
            //System.exit(0);
            dispose();    
        }
    });
	}
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==btn_yes)
            dispose();
    }
	
}

class TextEditor
{
    public static void main(String []args)
    {
        new MyMenues().setVisible(true);
    }
}