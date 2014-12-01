package com.thuocdo.ma.DAO;

import java.util.List;

import com.thuocdo.ma.Bean.AgeRank;

public interface IAgeRankDAO {
	/*
	 * Them mot age rank
	 */
	public AgeRank addAgeRank(int ar);
	/*
	 * Xoa mot age rank
	 */
	public AgeRank deleteAgeRank(int ar);
	/*
	 * Cap nhat age rank
	 */
	public AgeRank updateAgeRank(AgeRank ar);
	/*
	 * Lay danh sach cac do tuoi trong he thong
	 */
	public List<AgeRank> getAgeRankList();
	/*
	 * Lay do tuoi tuong voi agerankID
	 */
	public AgeRank getAgeRank(int AgeRankID);
	public AgeRank saveAndUpdateAgeRank(AgeRank ageRank);
}
