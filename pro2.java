while(ifmatch.find())
		{
			char chh[] = new char[acode.length()];
			count++;
			
			int no = ifmatch.end();
			
			int j = 0;
			
			while(j < acode.length())
			{
				char ch = code.charAt(no);
				
				chh[j] = ch;
				
				if(ch == ')')
				{
					break;
				}

				
				no++;
			}
			