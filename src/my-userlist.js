/**
 * @license
 * Copyright (c) 2016 The Polymer Project Authors. All rights reserved.
 * This code may only be used under the BSD style license found at http://polymer.github.io/LICENSE.txt
 * The complete set of authors may be found at http://polymer.github.io/AUTHORS.txt
 * The complete set of contributors may be found at http://polymer.github.io/CONTRIBUTORS.txt
 * Code distributed by Google as part of the polymer project is also
 * subject to an additional IP rights grant found at http://polymer.github.io/PATENTS.txt
 */

import { PolymerElement, html } from '@polymer/polymer/polymer-element.js';

import '@polymer/iron-form/iron-form.js';

import '@polymer/paper-input/paper-input.js';
import '@polymer/paper-button/paper-button.js';
import '@polymer/paper-toast/paper-toast.js'

import '@polymer/paper-dialog/paper-dialog.js';
import '@polymer/iron-ajax/iron-ajax.js';


import '@polymer/paper-dropdown-menu/paper-dropdown-menu.js';
import '@polymer/paper-item/paper-item.js';
import '@polymer/paper-listbox/paper-listbox.js';

import './shared-styles.js';

class UserList extends PolymerElement {

  static get properties() {
    return {
      users: {
        type: Array,
        value: []
      },
  
      selectedTrade: {
        type: String,
        value: ""
      },
     
      succesUserRegister: {
        type: String,
        value: "payment done successfully"
      },
      signUpFailedMsg: {
        type: String,
        value: "Something went wrong. Payment failed.."
      },
      pwdConfir: {
        type: String,
        value: "Something went wrong. Payment failed.."
      },
      
      listPage: {
        type: String,
        value: "http://127.0.0.1:8081/list"
      }


    };
  }
connectedCallback(){
  super.connectedCallback();
  this._getProfiles();
}
  _getProfiles() {
    const isValidate = this.$.tradeForm.validate();
      let ajaxRef = this.$.profileAjaxCall;
      ajaxRef.method = "get";
      ajaxRef.body = "";
      ajaxRef.url = "http://localhost:3000/profiles";
      ajaxRef.contentType = "application/json"
      ajaxRef.generateRequest();
    
    }
  

  _resetForm() {
    this.$.tradeForm.reset();
  }
  closeToast() {
    this.$.logintoast.hide();
  }
  _handleTradeResponse(event){
    const response = event.detail.response;
    this.trades = response; 
  }
  _handleResponse(event) {
    const response = event.detail.response;
    this.users = response; 
  
  }
  _currentUser(e){
    const isValidate = this.$.tradeForm.validate();
    let ajaxRef = this.$.tradeAjaxCall;
    ajaxRef.method = "get";
    ajaxRef.body = "";
    ajaxRef.url = "http://localhost:3000/trades";
    ajaxRef.contentType = "application/json"
    ajaxRef.generateRequest();
    this.$.stockListModel.open();
  }

  _selectedTrade(e){
    this.selectedTrade = e.target.name;
    this.tradeTime = new Date();
   // alert(this.selectedTrade);
    this.$.stockListModel.close();
    this.$.tradeDetailsListModel.open();
    //alert('_selectedTrade');
  }
  _goBack(){
    window.history.pushState({}, null, '/dashboard');
    window.dispatchEvent(new CustomEvent("location-changed"));
  }
  static get template() {
    return html`
      <style include="shared-styles">
      #tradeDetailsListModel{
        min-width: 600px;
      }
      paper-button.indigo {
        background-color: var(--paper-indigo-500);
        color: white;
        --paper-button-raised-keyboard-focus: {
          background-color: var(--paper-pink-a200) !important;
          color: white !important;
        };
      }
      paper-button.custom {
        --paper-button-ink-color: var(--paper-pink-a200);
        /* These could also be individually defined for each of the
          specific css classes, but we'll just do it once as an example */
        --paper-button-flat-keyboard-focus: {
          background-color: var(--paper-pink-a200) !important;
          color: white !important;
        };
        --paper-button-raised-keyboard-focus: {
          background-color: var(--paper-pink-a200) !important;
          color: white !important;
        };
      }
      paper-button.custom:hover {
        background-color: var(--paper-indigo-100);
      }
      paper-button.pink {
        color: var(--paper-pink-a200);
  
      }
      paper-button.custom:hover {
        background-color: var(--paper-indigo-100);
      }
      paper-button.pink {
        color: var(--paper-pink-a200);
  
      }
        :host {
          display: block;

          padding: 10px;
        }
      
        paper-button.indigo {
          background-color: var(--paper-indigo-500);
          color: white;
          --paper-button-raised-keyboard-focus: {
            background-color: var(--paper-pink-a200) !important;
            color: white !important;
          };
        }
      </style>

      <div class="card" id="cardContainer">

      
        <div class="">
        </div>
        <paper-dialog id="modal" modal>
        <p>
        [[signUpFailedMsg]]
      </p>   <div class="buttons">
          <paper-button dialog-confirm autofocus>Ok</paper-button>
        </div>
      </paper-dialog>
        <paper-toast id="signUpToast" class="fit-bottom" text="[[succesUserRegister]]"></paper-toast>
<iron-form id="tradeForm">
  <form>
      <h3>Welcome on Online Stock Trading : </h3>
          <paper-dropdown-menu label="Choose User">
            <paper-listbox slot="dropdown-content" class="dropdown-content">
                <template is="dom-repeat" items="{{users}}">
                    <paper-item  name="[[item]]"  on-click="_currentUser">[[item]]</paper-item>
                </template>    
            </paper-listbox>
          </paper-dropdown-menu>
      </form>
      </iron-form>
         </div>
         <iron-ajax
         id="profileAjaxCall"
         on-response="_handleResponse"
         on-error ="_handleError"
         debounce-duration="300">
     </iron-ajax>



     <!--Trades List dialog box start-->
     <paper-dialog id="stockListModel">
                <h2>Availables Stocks:</h2>
                <p>
              <div class="buttons">
                <paper-dropdown-menu label="Choose Trade">
                <paper-listbox slot="dropdown-content" class="dropdown-content">
                    <template is="dom-repeat" items="{{trades}}">
                        <paper-item  name="[[item.name]]"  on-click="_selectedTrade">[[item.name]]</paper-item>
                    </template>    
                </paper-listbox>
              </paper-dropdown-menu>
              </div>
            </form>
            </iron-form>
              </div>
              <iron-ajax
              id="tradeAjaxCall"
              on-response="_handleTradeResponse"
              on-error ="_handleError"
              debounce-duration="300">
            </iron-ajax>
                  <!-- <paper-button>More Info...</paper-button>
                  <paper-button dialog-dismiss>Decline</paper-button>
                  <paper-button dialog-confirm autofocus>Accept</paper-button>-->
                </div>
        </paper-dialog>
        <!--Trades List dialog box end-->



        <!--Trades Details dialog box start-->
        <paper-dialog id="tradeDetailsListModel">
                   <h4>Enter Trade Order details:</h4>
                   
                   <paper-input label="Stock Name" value="{{selectedTrade}}"></paper-input>
                   <paper-input label="Trade Booking Time" value="{{tradeTime}}"></paper-input>
                   <paper-textarea label="autoresizing textarea input"></paper-textarea>
                   <paper-input label="Trade Quantity"  type="number"></paper-input>

                   <paper-input label="disabled input" min="1" max="1200" disabled value="batman"></paper-input>
                   <paper-dropdown-menu label="Trade Type">
                   <paper-listbox slot="dropdown-content" class="dropdown-content">
                   <paper-item  name="sell">Sell</paper-item>
                   <paper-item name="buy">Buy</paper-item>
                     
                   </paper-listbox>
                 </paper-dropdown-menu>
             
             
                   </form>
               </iron-form>
                 </div>
                 <iron-ajax
                 id="tradeAjaxCall"
                 on-response="_handleTradeResponse"
                 on-error ="_handleError"
                 debounce-duration="300">
               </iron-ajax>
                   
                     <paper-button  class="custom indigo" dialog-dismiss>Confirm</paper-button>
                     <paper-button class="custom indigo" dialog-confirm autofocus>Cancel</paper-button>
                   </div>
           </paper-dialog>
           <!--Trades Details dialog box end-->
    `;

  }
}


window.customElements.define('user-list', UserList);
