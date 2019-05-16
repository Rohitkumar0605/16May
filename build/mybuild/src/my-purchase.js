define(["../shared_bundle_1.js"],function(_shared_bundle_){"use strict";class ItempurchaseElement extends _shared_bundle_.PolymerElement{static get properties(){return{succesLogin:{type:String,value:" Successfully"},hounseno:{type:String,value:""},streentNo:{type:String,value:""},city:{type:String,value:""},state:{type:String,value:""},country:{type:String,value:""},zipcode:{type:String,value:""},succesUserRegister:{type:String,value:"payment done successfully"},signUpFailedMsg:{type:String,value:"Something went wrong. Payment failed.."},pwdConfir:{type:String,value:"Something went wrong. Payment failed.."},listPage:{type:String,value:"http://127.0.0.1:8081/list"}}}_submitForm(){const isValidate=this.$.shoppingForm.validate();if(isValidate){const body={hounseno:this.hounseno,streentNo:this.streentNo,city:this.city,state:this.state,country:this.country,zipcode:this.zipcode};let ajaxRef=this.$.signUpAjax;ajaxRef.method="post";ajaxRef.body=body;ajaxRef.url="http://localhost:3000/purchased";ajaxRef.contentType="application/json";ajaxRef.generateRequest();/*
                                 this.signUpFailedMsg = this.pwdConfir;
                                    this.$.modal.open()
                                    this.$.shoppingForm.reset();
                                 */}}_resetForm(){this.$.shoppingForm.reset()}closeToast(){this.$.logintoast.hide()}_handleResponse(event){const response=event.detail.response;//if (response.username == this.username && response.password == this.password && response.conpassword == this.conpassword) {
this.$.signUpToast.fitInto=this.$.cardContainer;this.$.signUpToast.open();setTimeout(()=>{this.$.shoppingForm.reset();window.history.pushState({},null,"/dashboard");window.dispatchEvent(new CustomEvent("location-changed"))},1e3);/* } else {
                 alert(this.signUpFailedMsg);
                 //this.$.modal.open()
                 this.$.shoppingForm.reset();
               }*/}_goBack(){window.history.pushState({},null,"/dashboard");window.dispatchEvent(new CustomEvent("location-changed"))}static get template(){return _shared_bundle_.html`
      <style include="shared-styles">
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
        <div class=""></div>
        <paper-dialog id="modal" modal>
        <p>
        [[signUpFailedMsg]]
      </p>   <div class="buttons">
          <paper-button dialog-confirm autofocus>Ok</paper-button>
        </div>
      </paper-dialog>
        <paper-toast id="signUpToast" class="fit-bottom" text="[[succesUserRegister]]"></paper-toast>

        <iron-form id="shoppingForm">
        <form>
        <h1>Please fill all mandatory fields: </h1>
        <paper-input type="number" min="1" max="20" value="{{hounseno}}" always-float-label label="Hounse no" error-message="Please enter Hounse no " auto-validate required></paper-input></paper-input>
         <paper-input   min="1" max="20" value="{{streentNo}}" always-float-label label="Street" error-message="Please enter Streen No " auto-validate required></paper-input></paper-input>
        <paper-input min="1" max="20" value="{{city}}" always-float-label label="City" error-message="Please enter City name" auto-validate required></paper-input></paper-input>
        <paper-input min="1" max="20" value="{{state}}" always-float-label label="State" error-message="Please enter State name" auto-validate required></paper-input></paper-input>
        <paper-input min="1" max="20" value="{{country}}" always-float-label label="Country" error-message="Please enter country name" auto-validate required></paper-input></paper-input>
        <paper-input type="number" min="6"  value="{{zipcode}}" always-float-label label="Zipcode" error-message="Please enter range data" auto-validate required></paper-input></paper-input>
         
</br>
<paper-button class="custom indigo" on-click="_submitForm">Submit</paper-button>
<paper-button toggles class="custom indigo" class="green" on-click="_resetForm">Reset</paper-button>
<paper-button class="custom pink" on-click="_goBack">Back</paper-button>
</form>
         
         </div>
         <iron-ajax
         id="signUpAjax"
         on-response="_handleResponse"
         on-error ="_handleError"
         debounce-duration="300">
     </iron-ajax>
    `}}window.customElements.define("itempurchase-element",ItempurchaseElement)});