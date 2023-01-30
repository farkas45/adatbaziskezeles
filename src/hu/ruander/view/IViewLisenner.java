package hu.ruander.view;

public interface IViewLisenner {

	public void onButtonClickedCreateFrame();
	public void onButtonClickedSaveEmployee();
	public void onMouseClickedRowSelected(int id);
	public void onButtonClickedUpdatDate(int id);
	public void onButtonClickedDelete(int id);
	public void onButtonClickedSearch( String data);
	public void onButtonClickedCloseUpdateOrDelete();
	public void onButtonClickedCloseNewDataFrame();
}
