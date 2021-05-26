import {Component, OnInit} from "@angular/core";

interface Product {
  name: string;
  description: string;
  interestRate: number;
  image: string;
}

@Component({
  styleUrls: ['product-adviser.component.css'],
  templateUrl: './product-adviser.component.html'
})
export class ProductAdviserComponent implements OnInit {
  products: Product[] = [];
  ngOnInit(): void {
    this.products.push({name: 'Grønt boliglån', description: 'Siden du skal kjøpe en bolig med energimerke A eller B får du ekstra god rente med grønt boliglån', interestRate: 1.60, image: 'assets/green_flexiloan.svg'});
    this.products.push({name: 'Boliglån for unge', description: 'Siden du er ung for du bedre rente', interestRate: 1.65, image: 'assets/flexiloan.svg'});
    this.products.push({name: 'Boliglån', description: 'For tapere', interestRate: 1.80, image: 'assets/flexiloan.svg'});
  }

  next() {

  }

  select(product: Product) {
    
  }
}
