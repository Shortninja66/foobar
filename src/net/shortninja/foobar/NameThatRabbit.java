	public static String[] answer(String[] names)
	{
		Arrays.sort(names, new Comparator<String>()
		{
			@Override
			public int compare(String firstName, String secondName)
			{
				int response = 0;
				int firstNameValue = getNameValue(firstName);
				int secondNameValue = getNameValue(secondName);
				
				if(firstNameValue > secondNameValue)
				{
					response = -1;
				}else if(firstNameValue < secondNameValue)
				{
					response = 1;
				}else if(firstNameValue == secondNameValue)
				{
					if(getLexicographicallyLarger(firstName, secondName).equals(firstName))
					{
						response = -1;
					}else response = 1;
				}
				
				return response;
			}
		});
		
		return names;
	}
	
	private static int getNameValue(String name)
	{
		int value = 0;
		
		for(int i = 0; i < name.length(); i++)
		{
			value += getCharacterValue(name.charAt(i));
		}
		
		return value;
	}
	
	private static int getCharacterValue(char character)
	{
		return Character.getNumericValue(character) - 9;
	}
	
	private static String getLexicographicallyLarger(String firstName, String secondName)
	{
		String lexicographicallyLarger = "";
		int length = firstName.length() > secondName.length() ? secondName.length() : firstName.length();
		
		for(int i = 0; i < length; i++)
		{
			int firstCharacterValue = getCharacterValue(firstName.charAt(i));
			int secondCharacterValue = getCharacterValue(secondName.charAt(i));
		
			if(firstCharacterValue > secondCharacterValue)
			{
				lexicographicallyLarger = firstName;
				break;
			}else if (firstCharacterValue < secondCharacterValue)
			{
				lexicographicallyLarger = secondName;
				break;
            }
		}
		
		return lexicographicallyLarger;
	}
