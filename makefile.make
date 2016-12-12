#Arch, Ricardo
QPATH=-I/usr/include/qt
#QLIBS=
#Windows, Ricardo
#QPATH = -IC:/Qt/Qt5.7.0/5.7/mingw53_32/include
#QLIBS = -LC:/Qt/Qt5.7.0/5.7/mingw53_32/lib

## OBJETIVOS PRINCIPALES ####################################################

client: bin/client
	@echo '==> Run client'
	./bin/client ${ARGS}

test_ecc: bin/test_ecc
	@echo '==> Run test ecc'
	./bin/test_ecc ${ARGS}

crearCurvas: bin/crearCurvas
	@echo '==> Run crearCurvas'
	./bin/crearCurvas ${ARGS}

## LIGAR ###################################################################

bin/client: build/client.o build/crypto/crypto.o build/controlador.o
	@echo '==> Link client'
	mkdir -p bin
	g++ -std=c++11 -o bin/client build/client.o build/crypto/crypto.o build/crypto/modes.o build/crypto/3des.o build/crypto/aes.o build/crypto/des.o build/controlador.o build/moc_controlador.o -lQt5Qml -lQt5Gui -lQt5Core

bin/test_ecc: build/test_ecc.o build/crypto/ecc.o
	@echo '==> Link test ecc'
	mkdir -p bin
	g++ -std=c++11 -o bin/test_ecc build/test_ecc.o build/crypto/ecc.o build/crypto/eliptic_curves.o

bin/crearCurvas: build/crearCurvas.o build/crypto/eliptic_curves.o
	@echo '==> Link crearCurvas'
	mkdir -p bin
	g++ -std=c++11 -o bin/crearCurvas build/crearCurvas.o build/crypto/eliptic_curves.o

## COMPILAR #################################################################

build/client.o: src/client.cpp
	@echo '==> Compile client'
	mkdir -p build
	g++ -c -std=c++11  $(QPATH)/QtQml $(QPATH) $(QPATH)/QtGui $(QPATH) $(QPATH)/QtCore $(QPATH) -fPIC src/client.cpp -o build/client.o

build/test_ecc.o: src/test_ecc.cpp
	@echo '==> Compile test ecc'
	mkdir -p build
	g++ -c -std=c++11 src/test_ecc.cpp -o build/test_ecc.o

build/crearCurvas.o: src/crearCurvas.cpp
	@echo '==> Compile crearCurvas'
	mkdir -p build
	g++ -c -std=c++11 src/crearCurvas.cpp -o build/crearCurvas.o

build/controlador.o: src/controlador.cpp build/moc_controlador.o build/crypto/ecc.o
	@echo '==> Compile controlador'
	mkdir -p build
	g++ -c -std=c++11  $(QPATH)/QtQml $(QPATH) $(QPATH)/QtGui $(QPATH) $(QPATH)/QtCore $(QPATH) -fPIC src/controlador.cpp -o build/controlador.o

build/moc_controlador.o: src/controlador.h
	@echo '==> Generating Metacompiled source code'
	moc src/controlador.h -o src/moc_controlador.cpp
	@echo '==> Compile moc_controlador'
	mkdir -p build
	g++ -c -std=c++11  $(QPATH)/QtQml $(QPATH) $(QPATH)/QtGui $(QPATH) $(QPATH)/QtCore $(QPATH) -fPIC src/moc_controlador.cpp -o build/moc_controlador.o

build/crypto/crypto.o: src/crypto/crypto.cpp build/crypto/modes.o
	@echo '==> Compile crypto'
	mkdir -p build/crypto
	g++ -c -std=c++11  src/crypto/crypto.cpp -o build/crypto/crypto.o

build/crypto/ecc.o: src/crypto/ecc.cpp build/crypto/eliptic_curves.o
	@echo '==> Compile ecc'
	mkdir -p build/crypto
	g++ -c -std=c++11  src/crypto/ecc.cpp -o build/crypto/ecc.o

build/crypto/eliptic_curves.o: src/crypto/eliptic_curves.cpp
	@echo '==> Compile eliptic curves'
	mkdir -p build/crypto
	g++ -c -std=c++11  src/crypto/eliptic_curves.cpp -o build/crypto/eliptic_curves.o

build/crypto/modes.o: src/crypto/modes.cpp build/crypto/3des.o build/crypto/aes.o
	@echo '==> Compile modes'
	mkdir -p build/crypto
	g++ -c -std=c++11  src/crypto/modes.cpp -o build/crypto/modes.o

build/crypto/3des.o: src/crypto/3des.cpp build/crypto/des.o
	@echo '==> Compile 3des'
	mkdir -p build/crypto
	g++ -c -std=c++11  src/crypto/3des.cpp -o build/crypto/3des.o

build/crypto/aes.o: src/crypto/aes.cpp
	@echo '==> Compile aes'
	mkdir -p build/crypto
	g++ -c -std=c++11  src/crypto/aes.cpp -o build/crypto/aes.o

build/crypto/des.o: src/crypto/des.cpp
	@echo '==> Compile des'
	mkdir -p build/crypto
	g++ -c -std=c++11  src/crypto/des.cpp -o build/crypto/des.o

clean:
	rm -Rf build
