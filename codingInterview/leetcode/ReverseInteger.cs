public class Solution {
        public int Reverse(int x)
        {
            string str = x.ToString();
            char[] charArray = new char[str.Length];

            // Console.WriteLine(str);
            int startIndex = 0;
            if (str[0] == '-')
            {
                startIndex = 1;
                charArray[0] = str[0];
                for (int i = startIndex; i < charArray.Length; i++)
                {
                    charArray[i] = str[str.Length - i];
                }
            }
            else
            {
                for (int i = startIndex; i < charArray.Length; i++)
                {
                    charArray[i] = str[(str.Length - 1) - i];
                }
            }
            

            x = int.Parse(charArray);
            return x;
        }
    
}
