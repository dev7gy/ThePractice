BIN=bin/vi_cmd_search
LIB=lib_vi_cmd_srch
MAIN=main_vi_cmd_srch

make: $(LIB).o $(MAIN).o
	gcc -o $(BIN) ./$(LIB).o ./$(MAIN).o
clean:
	rm -rf $(BIN)
	rm -rf *.o
