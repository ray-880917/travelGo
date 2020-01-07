package google;
import java.io.IOException;
import java.util.ArrayList;

public class originalResult 
{
	public ArrayList<WebTree> resultTrees;
	public ArrayList<Keyword> lst=new ArrayList<Keyword>();
	public originalResult(String[][] s)
	{
		createKeywordList();
		createEachTree(s);
		setEachTreeScore();
	}
	
	public void createKeywordList()
	{
		lst.add(new Keyword("�ȹC",5));
		lst.add(new Keyword("�Ȧ�",5));
		lst.add(new Keyword("���",4));
		lst.add(new Keyword("�ۥѦ�",4));
		lst.add(new Keyword("����",4));
		lst.add(new Keyword("�q��",4));
		lst.add(new Keyword("��J",4));
		lst.add(new Keyword("���I",4));
		lst.add(new Keyword("��q",4));
		lst.add(new Keyword("���R",4));
		lst.add(new Keyword("����",3));
		lst.add(new Keyword("���J",3));
		lst.add(new Keyword("�C��",3));
		lst.add(new Keyword("���§",2));
		lst.add(new Keyword("ñ��",2));
		lst.add(new Keyword("�ײv",1));
		lst.add(new Keyword("trip",5));
		lst.add(new Keyword("travel",5));
		lst.add(new Keyword("tour",5));
		lst.add(new Keyword("journey",5));
		lst.add(new Keyword("go traveling",4));
		lst.add(new Keyword("group tour",4));
		lst.add(new Keyword("travel with a group",4));
		lst.add(new Keyword("independent travel",4));
		lst.add(new Keyword("travel alone",4));
		lst.add(new Keyword("air ticket",4));
		lst.add(new Keyword("passenger ticket",4));
		lst.add(new Keyword("ticket",4));
		lst.add(new Keyword("booking",4));
		lst.add(new Keyword("check in",2));
		lst.add(new Keyword("accomodation",4));
		lst.add(new Keyword("scenic spot",4));
		lst.add(new Keyword("tourism",4));
		lst.add(new Keyword("transportation",4));
		lst.add(new Keyword("must buy",4));
		lst.add(new Keyword("hotel",3));
		lst.add(new Keyword("homestay",3));
		lst.add(new Keyword("bnb",3));
		lst.add(new Keyword("hostel",3));
		lst.add(new Keyword("gift",2));
		lst.add(new Keyword("souvenir",2));
		lst.add(new Keyword("visa",2));
		lst.add(new Keyword("exchange rate",1));
    }
	
	public void createEachTree(String[][] s)
	{
		resultTrees=new ArrayList<WebTree>();
		for(String[] s1:s)
		{
			WebTree t= new WebTree(new WebPage(s1[1],s1[0]));			
			resultTrees.add(t);
			try
			{
				t.root.findChildren();
			}
			catch(Exception e)
			{
				
//				e.printStackTrace();
				continue;
			}
		}
		
	}
	
	public void setEachTreeScore()
	{
		System.out.println("tree��"+resultTrees.size()+"��");
		for(WebTree tree : resultTrees)
		{
			
			try
			{
				tree.setPostOrderScore(lst);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			System.out.println("root: "+tree.root.webPage.name+" score: "+tree.root.nodeScore+"\ndone");
		}
	}
	
	
}
