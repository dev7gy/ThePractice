#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <malloc.h>

int main(int argc, char* argv[]) {
	char* file_path = NULL;
	if (argc > 2)  {
		file_path = argv[1];
	} else {
		file_path = "./fopen.txt";
	}
	FILE* fp = fopen(file_path, "w");
	if(fp)
	{
		printf("Success\nargc: %d\nfile_path: %s\n", argc, file_path);
		srand((unsigned int)time(NULL));

		for (int i =1; i <= 10; i++) 
		{
			fprintf(fp, "%d ", rand()%100+1);
		}
		fclose(fp);
	}
	else
	{
		printf("fail\n");
	}

	char* shell_command = (char*)malloc(sizeof(char) * 20);
	strcpy(shell_command, "cat ");
	strcat(shell_command, file_path);
	//strcat(shell_command, file_path);
	int status = system(shell_command);
	free(shell_command);

	fp = fopen(file_path, "r");
	char* buffer = (char*)malloc(sizeof(char) * 100);
	if(fp)
	{
		//fgets(buffer, sizeof(*buffer), fp);
		//fgets(buffer, _msize(buffer), fp);
		fgets(buffer, malloc_usable_size(buffer), fp);
		printf("hello: %s\n", buffer);
	}
	free(buffer);
	fclose(fp);

	return status;
}
