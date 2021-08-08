#include "lib_vi_cmd_srch.h"
char* DATA_FILE = "cmd_data";
int main()
{
	FILE* fp;
	TN_L new_list;
	TN* temp_table = NULL;
	//using command_search
	int temp_total_data_index = -1;
	CD* temp_data = NULL;
	
	//table_list초기화
	new_list.head = NULL;
	new_list.tail = NULL;
	new_list.cur = NULL;
	//파일읽고 내용 읽어오기
	fp = fopen(DATA_FILE, "r");
	if (fp == NULL)
	{
		puts("파일오픈 실패!");
		return FALSE;
	}
	Read_File(fp, &new_list);
	fclose(fp);
	//메뉴실행
	while (1)
	{
		int menu_i = menu();
		if (menu_i == 1)
		{
			FREE_ALL(&new_list);
			printf("BYE BYE\n");
			return 0;
		}
		else if (menu_i == 2)
		{
			printf("SEARCH KEYWORD\n");
			printAllKey(&new_list);
			temp_table = KeySearch(&new_list);
			temp_total_data_index = PrintName(&new_list, temp_table);
			printf("찾은 키워드 갯수: %d\n", temp_total_data_index);
		}
		else if (menu_i == 3)
		{
			printf("SEARCH COMMAND\n");
			PrintName(&new_list, temp_table);
			temp_data = NameSearch(&new_list, temp_table, temp_total_data_index);
			printData(temp_data);
		}
	}
}
