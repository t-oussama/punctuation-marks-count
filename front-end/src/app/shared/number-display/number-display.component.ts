import { Component, OnInit, Input, OnChanges } from '@angular/core';

@Component({
  selector: 'app-number-display',
  templateUrl: './number-display.component.html',
  styleUrls: ['./number-display.component.css']
})

/*
  Displays a number (of at most 10 digits, configurable) in an animated way.
*/
export class NumberDisplayComponent implements OnChanges {

  MAX_FIGURES_COUNT = 10;
  @Input() number = 0;
  // The figures that form the final number to display
  figures = new Array(this.MAX_FIGURES_COUNT);

  /*
    The figures that will be incremented with a slight delay until the final number is reached
    This is the array used to make the number display "animated".
  */
  displayCounters = new Array(this.MAX_FIGURES_COUNT);

  constructor() { }

  // This will be executed whenever a new number is set.
  async ngOnChanges() {

    const numberString = this.number.toString();

    // Copy the number's figures to the figures array, and set the value '0' for the unused columns.
    for (let i = 0; i < this.MAX_FIGURES_COUNT; i++) {

      // if the value of "i" reaches the index of the column where the actual number starts, write it's value one digit at a time
      if (i >= this.MAX_FIGURES_COUNT - numberString.length) {
        this.figures[i] = numberString[i + numberString.length - this.MAX_FIGURES_COUNT];
      } else {
        // if we are still counting the unused columns just set '0'.
        this.figures[i] = '0';
      }

      // The digits to be displayed and incremented are initialized at '0'.
      this.displayCounters[i] = '0';
    }

    // Increment the displayCounters columns independently from one an other (incrementFigure is non blocking)
    for (let i = 0; i < this.MAX_FIGURES_COUNT; i++) {
      this.incrementFigure(i);
    }
  }


  // Increments the displayCounter of index "i" with a 200ms delay, until it reaches its final value saved in this.figures[i]
  // NOTE: Figure values range from 0 to 9, so we will have a maximum of 10 recursive calls wich is acceptable to every browser.
  private incrementFigure(i: number) {
    // Run a non blocking incrementation with 200ms delay
    setTimeout((() => {
      // After the delay ...
      // if we haven't reached the desired value, increment displayCounter by 1  and make a new call to be executed after an other 200ms.
      if (this.displayCounters[i] < this.figures[i]) {
        this.displayCounters[i]++;
        this.incrementFigure(i);
      } else {
        // if the desired value is reached, exit the recursive call.
        return ;
      }
    }).bind(this), 200);
  }
}
