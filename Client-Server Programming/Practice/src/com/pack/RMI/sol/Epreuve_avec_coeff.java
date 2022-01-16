package com.pack.RMI.sol;

public class Epreuve_avec_coeff implements Epreuve
{
	public double _note;
	public String _nom_epreuve;
	public double _coefficient;

	public Epreuve_avec_coeff (double note, String nom_epreuve, double coefficient)
	{
		_note=note;
		_nom_epreuve=nom_epreuve;
		_coefficient=coefficient;
	}

	public String afficher()
	{
		return "Epreuve " + _nom_epreuve + ": " + _note; 
	}

	public double note() 
	{
		return _note*_coefficient;
	}
}
