package com.zensar.Entity;

import java.util.List;

public class LeadNamesEntity {

	private List<String> leadnames;
	private String selectedOption;

	public String getSelectedOption() {
		return selectedOption;
	}

	public void setSelectedOption(String selectedOption) {
		this.selectedOption = selectedOption;
	}

	public List<String> getLeadnames() {
		return leadnames;
	}

	public void setLeadnames(List<String> leadnames) {
		this.leadnames = leadnames;
	}

	@Override
	public String toString() {
		return "LeadNamesEntity [leadnames=" + leadnames + ", selectedOption=" + selectedOption + "]";
	}

}
