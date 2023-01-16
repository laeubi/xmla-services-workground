package org.eclipse.daanse.db.datasource.common.extender;

import java.sql.DriverPropertyInfo;

import org.osgi.service.metatype.AttributeDefinition;

public class DriverPropertyInfoAttributeDefinition implements AttributeDefinition{
	
	private DriverPropertyInfo propertyInfo;

	public DriverPropertyInfoAttributeDefinition(DriverPropertyInfo propertyInfo) {
		this.propertyInfo = propertyInfo;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCardinality() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getOptionValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getOptionLabels() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String validate(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getDefaultValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
