I solved the first challenge – “SALES TAXES”. For this, I followed the steps:

  1-	Started apersonal  GitHub account (assuming this one! 😉)
  2-	Created a new Project in Eclipse (Sales-Receipt)
  3-	Added Pom.xml and a few necessary preliminary dependencies
  4-	3- Added a main java class (com.sina.receipt.main.java)
  5-	Converted the project to a Maven repository
  6-	Created the following modules and classes:
    Receipt.java: the reference java class, which conducts the whole process and is run by main.java
      Invoice.java: prepares the invoice and is called by Receipt.java
      Input.java: Gets the inputs (purchased article, quantity, price per unit, whether the article is imported and whether the article is tax exempt); called by Invoice.java
      Validations.java: Is called by Input.java and validates its entries
      SaleItem.java: Data model for an item on an invoice (used in the entire program)
      TaxRate.java: Delivers the tax rate for an article on the invoice (according to whether it is imported and whether it is tax exempt)

    Output.java: prepares the invoice and is called by Receipt.java
      CalculateTax.java: Calculates the taxed price and the output for the final invoice
      ImportOutput.java: An Enum class to prepare import related part on the invoice

I tried to keep everything very simple and made a lot of assumptions:
  •	the user enters the articles name and unit using underscores instead of spaces
  •	quantity / amount is an integer (no 3.5 Kgr is accepted, but 3)
  •	and a few more

I kept to the principle of short and self-explanatory classes
I practiced of decoupling.
I implemented via Test-Driven-Development as far as it was related to calculations.

For any question, please reach out to me via sina.p.hgahi@gmail.com
