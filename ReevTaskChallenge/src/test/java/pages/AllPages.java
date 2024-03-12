package pages;



public class AllPages {
	public AllPages() {
	}

	private BackOfficePage backOfficePage;



	private HomePage homePage;

	public HomePage homePage() {
		if (homePage == null) {
			homePage = new HomePage();
		}
		return homePage;
	}



	public BackOfficePage backOfficePage() {
		if (backOfficePage == null) {
			backOfficePage = new BackOfficePage();
		}
		return backOfficePage;
	}

}
