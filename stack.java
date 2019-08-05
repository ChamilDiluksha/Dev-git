		
		sta sf = new sta(ff.length());
		
		for (int i = 0; i < ff.length(); i++) {
			
			char ch = ff.charAt(i);
			
			if(ch == '(')
				sf.push(ch);
			
			else if (ch == ')') {
				char c = sf.pop();
				
				if(c != '(')
				{
					System.out.println("Invalid");
					return;
				}
				
			}			
		}
