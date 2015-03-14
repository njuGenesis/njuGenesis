package bslogicService;

import data.po.PlayerDataPO;

public interface PlayerInfoService {
	public void analysData(String name);
	public PlayerDataPO getInfo(String name);
	public void setOrder(String orderName);
	public PlayerDataPO[] getAllInfo();
	public PlayerDataPO[] getFirstFifty(String orderName);
}
