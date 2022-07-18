<template>
  <div class="hints-wrapper">
    <div class="hint-title">
      <i class="vue-dsn-icon-tishi" />
      <span><slot name="hintName" /></span>
    </div>
    <div class="hint-info">
      <slot name="hintInfo" />
    </div>
  </div>
</template>

<script>
export default {
  name: 'Hints'
}
</script>

<style lang="less">
.hints-wrapper{
  width: 100%;
  min-height: 50px;
  padding: 8px 15px;
  margin-bottom: 20px;
  background: #959da8;
  box-sizing: border-box;
  .hint-title{
    line-height: 30px;
    font-size: 16px;
    color: #ffffff;
    i{
      font-size: 18px;
    }
  }
  .hint-info{
    padding-left: 24px;
    line-height: 24px;
  }
}
</style>
