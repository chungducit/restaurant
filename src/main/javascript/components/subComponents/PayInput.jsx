import React from 'react';

class PayInput extends React.Component {

  constructor(props) {
    super(props);
    this.handleChangeInput = this.handleChangeInput.bind(this);
  }

  handleChangeInput (e) {
    this.props.onChange(e);
  }

  render() {
    return (
        <div className="form-group row no-gutters">
            <label className="col-4 col-form-label">{this.props.label}</label>
            <div className="col-5">
                <input type={this.props.type} 
                       onChange={this.handleChangeInput} 
                       value={this.props.value} className="form-control" />
            </div>
            <div className="col-3">{this.props.msg}</div>
        </div>
      );
  }

}

export default PayInput;