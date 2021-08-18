// "111111111111111111111111111111111111111111111" -> time limit
public class Solution {
    public int NumDecodings(string s) {
        int count = 0;
        RecursiveCount(s, ref count);
        return count;
    }
    
    public void RecursiveCount(string s, ref int cnt)
    {
        if(s[0] == '0')
        {
            return;
        }
        
        int num = -1;
        if(s.Length == 1)
        {
            num = Int32.Parse(s);
            if(num > 0 && num < 10)
            {
                cnt++;
            }
        }
        else if(s.Length == 2)
        {
            num = Int32.Parse(s);
            if(num > 9 && num < 27)
            {
                cnt++;
            }
            num = Int32.Parse(s.Substring(0,1));
            if(num > 0 && num < 10)
            {
                RecursiveCount(s.Substring(1), ref cnt);
            }
        }
        else 
        {
            num = Int32.Parse(s.Substring(0,1));
            if(num > 0 && num < 10)
            {
                RecursiveCount(s.Substring(1), ref cnt);
            }
            num = Int32.Parse(s.Substring(0, 2));
            if(num > 9 && num < 27)
            {
                RecursiveCount(s.Substring(2), ref cnt);
            }
        }
    }
}
