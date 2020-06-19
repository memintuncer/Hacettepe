CC = gcc

TARGET = Simon
SOURCES = main.c

all: $(TARGET)

$(TARGET): $(SOURCES)
	$(CC) $(SOURCES) -o $(TARGET) -lm

.PHONY: clean

clean:
	$(RM) $(TARGET)

