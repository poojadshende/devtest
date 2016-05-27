package com.build.devtest;

import java.util.List;
import java.util.ArrayList;

public class ParentViewMapperImpl implements ParentViewMapper 
{
	public List<ParentView> mapRowsToViews(List<ParentRow> parentRows, List<ChildRow> childRows)
        {
		List<ParentView> parentViewList=new ArrayList<ParentView>(); 
		for (ParentRow parentRow : parentRows) 
		{
			String parentID = parentRow.getParentId();
			ParentView parentView = new ParentView(parentRow.getFirstName(), parentRow.getLastName(), parentRow.getAge(), parentRow.getParentId(), null);
			List<ChildView> childList;
			childList = new ArrayList<ChildView>();
			for(ChildRow childRow : childRows)
			{
				String childPID = childRow.getParentId();
				if(childPID.compareToIgnoreCase(parentID)==0)
				{
					ChildView childView = new ChildView(childRow.getFirstName(), childRow.getLastName(), childRow.getAge(), childRow.getChildId(), parentView);
					childList.add(childView);
				}
					
			}
			parentView.setChildViews(childList);
			parentViewList.add(parentView);
		}
		return parentViewList;
	}
}
