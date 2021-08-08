#ifndef __VI_COMMAND_SEARCH__
#define __VI_COMMAND_SEARCH__

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define STR_MAX 200
#define TABLE_MAX 2
#define TRUE 1
#define FALSE -1

//define struct
typedef int T_F;
typedef char* prj_STR;
typedef struct CDATA
{
        char name[20];
        char func[80];
        char key[20];
        char use[80];
}CD;

typedef struct TABLE_NODE
{
        char key[20];
        CD* data_list[TABLE_MAX];
        int list_index;
        struct TABLE_NODE* pnext;
}TN;

typedef struct TN_LIST
{
        TN* head;
        TN* cur;
        TN* tail;
}TN_L;

//func define
T_F Read_File(FILE* fp, TN_L* list);
int menu(void);
T_F FREE_ALL(TN_L* list);
void RemoveBSN(char str[]);
TN* KeySearch(TN_L* list);
int PrintName(TN_L* list, TN* find_table);
CD* NameSearch(TN_L* list, TN* recorded_table, int total_index);
void printData(CD* find_data);
T_F createTableInputData(TN_L* list, CD* data);
void printAllKey(TN_L* list);
#endif
