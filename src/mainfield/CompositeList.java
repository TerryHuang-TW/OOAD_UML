package mainfield;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CompositeList {
	private ArrayList<CaseItem[]> _compositelist = new ArrayList<CaseItem[]>();
	private Map<CaseItem, Integer> _compolayerMap = new HashMap<CaseItem, Integer>();
	
	public CaseItem[] getGroupList(CaseItem member)
	{
		CaseItem[] glist = null;
		int length = Integer.MIN_VALUE;
		for(CaseItem[] c_array: _compositelist)
		{
			for(CaseItem c: c_array)
			{
				if(member == c && c_array.length > length)
				{
					glist = c_array;
					length = glist.length;
				}
			}
		}
		System.out.println(glist);
		return glist;
	}
	
	public void modifyGroupLayer(CaseItem[] glist, boolean isadding)
	{
		for(CaseItem c: glist)
		{
			if(_compolayerMap.containsKey(c))
			{
				int layer = _compolayerMap.get(c);
				if(isadding == true)
					layer += 1;
				else
					layer -= 1;
				_compolayerMap.put(c, layer);
				if(layer == 0)
					c.setGroupStatus(false);
				System.out.print(_compolayerMap.get(c) + " ");
			}
			else
				_compolayerMap.put(c, 1);
		}
	}
	
	public ArrayList<CaseItem[]> getCompositeList()
	{
		return _compositelist;
	}
}
