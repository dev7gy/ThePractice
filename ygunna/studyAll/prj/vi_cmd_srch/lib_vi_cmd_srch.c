#include "lib_vi_cmd_srch.h"
//1. read_file
T_F Read_File(FILE* fp, TN_L* list)
{
	//fopen_s(&fp, file_name, "r");
	while (feof(fp) == 0)
	{
		char input_str[STR_MAX];
		char token[] = "\t\n";
		//char* after_str = NULL; in WINDOWS
		fgets(input_str, sizeof(input_str), fp);
		RemoveBSN(input_str);	
		CD* data = NULL;
		//data만들기
		if(strlen(input_str) < strlen("a	b	c"))
		{
			printf("warning: << %s >> can't insert table\n\n", input_str);
			continue;
		}
		else
		{
			data = (CD*)malloc(sizeof(CD));
			strcpy(data->name, strtok(input_str, token));
			strcpy(data->func, strtok(NULL, token));
			strcpy(data->key, strtok(NULL, token));
			//마지막 비고값은 비어있을 수도 차있을 수도 있으므로 확인 필요
			char* temp = strtok(NULL, token);
			if (temp != NULL)
			{
				printf("\nFIELD: 4\nKEYWORD: %s\nCOMMAND: %s\n",data->key, data->name);
				strcpy(data->use, temp);
			}
			else
			{
				printf("\nFIELD: 3\nKEYWORD: %s\nCOMMAND: %s\n",data->key, data->name);
				strcpy(data->use, " ");
			}
		}
		//맨 앞에서부터 탐색
		list->cur = list->head;
		while (1)
		{
			//table이 하나도 없으면
			if (list->head == NULL)
			{
				TN* table = (TN*)malloc(sizeof(TN));
				list->head = table;
				list->cur = list->head;
				list->tail = list->cur;
				//table설정 후 데이터 넣기
				strcpy(list->cur->key, data->key);
				list->cur->data_list[0] = data;
				list->cur->list_index = 1;
				list->cur->pnext = NULL;
				break;
			}
			//입력하려는 data의 키값과 table의 키값이 같으면
			else if (strcmp(list->cur->key, data->key) == 0)
			{
				//table이 꽉 차면
				if (list->cur->list_index == TABLE_MAX)
				{
					//다음 table이 없는 경우
					if (list->cur->pnext == NULL)
					{
					 	createTableInputData(list, data);
						list->tail = list->cur;
						break;
					}
					//다음 table이 있는 경우
					else
					{
						//다음 테이블key값과 data key값이 같은 경우
						if (strcmp(list->cur->pnext->key, data->key) == 0)
						{
							list->cur = list->cur->pnext;
							continue;
						}
						//그외
						else
						{
					 		createTableInputData(list, data);
							break;
						}
					}
				}
				//table이 꽉 차지 않았을 경우
				else
				{
					list->cur->data_list[list->cur->list_index] = data;
					list->cur->list_index++;
					break;
				}
			}
			//입력하려는 data의 키값과 table의 키 값이 다르면
			else if (strcmp(list->cur->key, data->key) != 0)
			{
				//다음 table이 NULL이면
				if (list->cur->pnext == NULL)
				{
					createTableInputData(list, data);
					list->tail = list->cur;
					break;
				}
				//다음 table의 key값이 같든 다르든 cursor가 넘어가야함
				else
				{
					list->cur = list->cur->pnext;
					continue;
				}
			}
			//일어날 수 없는 문장
			else
			{
				return FALSE;
			}
		}
	}
	return TRUE;
}

//2. print menu
int menu(void)
{
	int menu_num;
	//이상하게 치는 경우를 대비하여 넉넉하게 10을 할당
	char menu_str[10];
	puts("\n\n=======\n===MENU");
	puts("==1.EXIT");
	puts("==2.search KEYWORD");
	puts("==3.search COMMAND\n\n=======");

	do {
		printf("plz input 1-3\n");
		fgets(menu_str, sizeof(menu_str), stdin);
		RemoveBSN(menu_str);	
		//atoi함수는 숫자로 변환할 수 없을때 0을 반환
		menu_num = atoi(menu_str);
	} while (menu_num > 3 || menu_num <= 0);
	system("clear");
	return menu_num;
}

//3. delete all
T_F FREE_ALL(TN_L* list)
{
	if (list->head != NULL)
	{
		list->cur = list->head;
		while (list->cur != NULL)
		{
			while (list->head->list_index > 0)
			{
				printf("FREE!!: %s table <<%s>>\n", list->head->key, list->head->data_list[(list->head->list_index) - 1]->name);
				free(list->head->data_list[(list->head->list_index) - 1]);
				list->head->list_index--;
			}
			//다음 table 미리 저장
			list->cur = list->head->pnext;
			printf("FREE!!: <<%s>> table\n\n", list->head->key);
			free(list->head);
			list->head = list->cur;
		}
		return TRUE;
	}
	else
	{
		puts("Heap영역에 지울것이 존재하지 않습니다.");
		return FALSE;
	}
}

//4. delete enter
void RemoveBSN(char str[])
{
	int len = strlen(str);
	str[len-1] = 0;
}

//5. table_keyword_search
TN* KeySearch(TN_L* list)
{
	TN* temp = NULL;
	list->cur = list->head;
	char search_str[20];
	fgets(search_str, sizeof(search_str), stdin);
	RemoveBSN(search_str);	
	while (TRUE)
	{
		
		if (list->cur == NULL)
		{
			return temp;
		}
		
		else
		{
			
			if (strcmp(list->cur->key, search_str) == 0)
			{
				puts("\n\n============\nFIND KEYWORD\n");
				temp = list->cur;
				return temp;
			}
			list->cur = list->cur->pnext;  
		}
	}
	return NULL;
}

//6. print command included table_key
int PrintName(TN_L* list, TN* find_table)
{
	if (find_table == NULL) return 0;
	else
	{
		int total_index = 0;
		list->cur = find_table;
		while (TRUE)
		{	//현재 테이블이 NULL일때
			if (list->cur == NULL)
			{
				return total_index;
			}
			else
			{	//현재의 키값이 찾으려하는 키값과 다를떄
				if (strcmp(list->cur->key, find_table->key) != 0)
				{
					return total_index;
				}
				int table_index = 0;
				for (table_index; table_index < list->cur->list_index; table_index++)
				{
					printf("Index: %d: Command: %s\n", total_index+1, list->cur->data_list[table_index]->name);
					total_index++;
				}
			}
		
			list->cur = list->cur->pnext;
		}	
		return total_index;
	}
}

//7. find command using table
CD* NameSearch(TN_L* list, TN* recorded_table, int total_index)
{	
	CD* temp = NULL;
	char search_str[20];
	int atoi_str = -1;
	if (recorded_table == NULL)
	{
		printAllKey(list);
		puts("FINDED TABLE: NULL");
		puts("\n\n!!! It does not search through INDEX. !!!\n!!! we recommend that you do  KEYWORD SEARCH first !!!\n");
		do {
			puts("plz input string, not number\n");
			fgets(search_str, sizeof(search_str), stdin);
			RemoveBSN(search_str);
			//atoi함수는 숫자로 변환할 수 없을 때 0을 반환
			//0이아니라는 것은 숫자라는 것
		}while (atoi(search_str) != 0);
		//문자 검색이니 head부터 시작
		list->cur = list->head;
		while (TRUE)
		{
			if (list->cur == NULL) return temp;
			else
			{
				//table마다 검색
				int data_index = 0;
				for (data_index; data_index < list->cur->list_index; data_index++)
				{
					if (strcmp(search_str, list->cur->data_list[data_index]->name) == 0)
					{
						puts("============\nFIND COMMAND\n");
						temp = list->cur->data_list[data_index];
						return temp;
					}
				}
				list->cur = list->cur->pnext;
			}
		}
	}
	else
	{
		printf(" FINDED TABLE: %s\n", recorded_table->key);
		do {
			printf("plz input number[1-%d]\n!!! If you enter a STRING, it will search from the FIRST TABLE !!!\n", total_index);
			fgets(search_str, sizeof(search_str), stdin);
			RemoveBSN(search_str);
			//atoi함수는 숫자로 변환할 수 없을 때 0을 반환
			//0이면 문자 그외 숫자면 숫자로 받아들임
			atoi_str = atoi(search_str);
		}while (atoi_str > total_index);
		
		//숫자면 table값이 있다는 것이므로
		if (atoi_str != 0)
		{
			list->cur = recorded_table;
			int key_index = 0;
			int cur_table_index = atoi_str%TABLE_MAX;
			int move_table = atoi_str/TABLE_MAX;
			//printf("%d %d %d\n", atoi_str, cur_table_index, move_table);
			if (cur_table_index == 0)
			{
				move_table--;
				cur_table_index+=TABLE_MAX;
			}	
			for (key_index; key_index< move_table; key_index++)
			{
				list->cur = list->cur->pnext;
			}
			temp = list->cur->data_list[cur_table_index-1];
			
			//printf(">>%d %d %d\n", atoi_str, cur_table_index, move_table);
			return temp;
			
		}
		else
		{
			list->cur = list->head;
			while (TRUE)
			{	
				//숫자일 경우엔 위에서 한번 걸렀으므로 못찾을리가 없음.
				if (list->cur == NULL) return temp;
				/*고민해봐야함
				else if (strcmp(recorded_table->key, list->cur->key) != 0)
				{
					return temp;
				}
				*/
				else
				{
					//table마다 검색
					int data_index = 0;
					for (data_index; data_index < list->cur->list_index; data_index++)
					{
						if (strcmp(search_str, list->cur->data_list[data_index]->name) == 0)
						{
							puts("============\nFIND COMMAND\n");
							temp = list->cur->data_list[data_index];
							return temp;
						}
					}
					list->cur = list->cur->pnext;
				}	
			}
		}
	}

}

//8. prinf detail using CommandData
void printData(CD* find_data)
{
	if (find_data != NULL)
	{
		printf("Command: %4s\nFunc: %4s\nKey: %4s\nRemarks: %4s\n\n", find_data->name, find_data->func, find_data->key, find_data->use);
	}
	else
	{
		puts("NOT FOUND\n");
	}
}
//9.create table && input data 
T_F createTableInputData(TN_L* list, CD* data)
{				
	TN* table = (TN*)malloc(sizeof(TN));
	//새로 생성한 table의 next에 현재 table next먼저 연결
	table->pnext = list->cur->pnext;
	list->cur->pnext = table;
	//table이동 후 데이터 넣기
	list->cur = list->cur->pnext;
	strcpy(list->cur->key, data->key);
	list->cur->data_list[0] = data;
	list->cur->list_index = 1;
	return TRUE;
}

//10. print_all_key
void printAllKey(TN_L* list)
{
	char compare_key[20]=" ";
	list->cur = list->head;
	while(list->cur != NULL)
	{
		if (strcmp(compare_key, list->cur->key) != 0)
		{
			printf("%s\n", list->cur->key);
			strcpy(compare_key, list->cur->key);
		}
		list->cur = list->cur->pnext;
	}
	puts("\n==== KEY ====\n");	
} 
