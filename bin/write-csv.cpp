#include <iostream>
#include <random>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

int main() {
	
	string fileName;
	int nrows;
	bool random = false;
	int first = 1234567890;

	cout << "Enter file name: ";
	cin >> fileName;
	cout << "Enter number of records: ";
	cin >> nrows;
	cout << "Random ? <y/n>: ";
	char answer;
	cin >> answer;
	if (answer =='y' || answer == 'Y') {
		random = true;
	}
	
	ofstream outFile (fileName.c_str());
	string line;
	string SKU;
	if (random == false) {
		for (int i = 0; i < nrows; i++) {
			line = "";
			SKU = to_string(first + i);
			line += SKU;
			line += ",10";
			line += ",1000";
			line += ",1";
			line += ",1";
			line += ",shampoo";
			line += ",the world's greatest shampoo\n";
			outFile << line;
		}
		outFile.close();
	} else {
		default_random_engine generator;
		uniform_int_distribution<int> distribution(0, nrows - 1);
		vector<string> lines;
		for (int i = 0; i < nrows; i++) {
			line = "";
			SKU = to_string(first + i);
			line += SKU;
			line += ",10";
			line += ",1000";
			line += ",1";
			line += ",1";
			line += ",shampoo";
			line += ",the world's greatest shampoo\n";
			lines.push_back(line);
		}
		for (int i = 0; i < nrows / 2; i++) {
			int one = distribution(generator);
			int two = distribution(generator);
			swap(lines[one], lines[two]);
		}
		for (int i = 0; i < nrows; i++) {
			outFile << lines[i];
		}
		outFile.close();
	}

	return 0;
}
