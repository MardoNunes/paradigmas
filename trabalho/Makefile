# Nome do arquivo .java principal
MAIN = BancoImobiliario

# Variável para os arquivos .java
SOURCES = $(wildcard *.java)

# Variável para os arquivos .class correspondentes
CLASSES = $(SOURCES:.java=.class)

# Variável para o compilador Java
JAVAC = javac

# Alvo principal para compilar o programa
all: $(MAIN)

# Compilar o arquivo principal e dependências
$(MAIN): $(CLASSES)

%.class: %.java
	$(JAVAC) $<

# Limpa os arquivos .class
clean:
	rm -f *.class
