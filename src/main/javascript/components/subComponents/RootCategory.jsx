import React from 'react';

class RootCategory extends React.Component {

    constructor(props) {
        super(props);

        this.handleClickOnRootCategory = this.handleClickOnRootCategory.bind(this);
    }

    handleClickOnRootCategory () {
        this.props.onClickRootCategory(this.props.category);
    }

    render() {
      let category = this.props.category;
      let active = this.props.selected == category.id ? ' active' : '';
      return (
        <div className={'col-6 cate' + active} onClick={this.handleClickOnRootCategory}>{category.name}</div>
      );
    }
  
}

  
export default RootCategory;