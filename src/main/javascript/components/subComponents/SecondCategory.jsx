import React from 'react';

class SecondCategory extends React.Component {

    constructor(props) {
        super(props);

        this.handleClickOnSecondCategory = this.handleClickOnSecondCategory.bind(this);
    }

    handleClickOnSecondCategory () {
        this.props.onClickSecondCategory(this.props.category);
    }

    render() {
      let category = this.props.category;
      let active = this.props.selected == category.id ? ' active' : '';
      return (
        <div className="col-4 cate-child-item" onClick={this.handleClickOnSecondCategory}>
            <div className={'cate-child-inner' + active }>{category.name}</div>
        </div>
      );
    }
  
}

  
export default SecondCategory;