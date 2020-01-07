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
