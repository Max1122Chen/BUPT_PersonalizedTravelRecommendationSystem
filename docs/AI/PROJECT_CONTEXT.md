# PROJECT_CONTEXT

最后更新：2026-03-28

## 1. 项目定位
- 名称：个性化旅游推荐系统（数据结构课程设计）
- 目标：实现推荐、路线规划、设施查询、美食推荐、日记管理与后台管理。
- 重点：数据结构与算法在业务中的落地能力。

## 2. 当前技术栈（已落地）
- 前端：Vue 3 + TypeScript + Vite + Pinia + Element Plus + ECharts
- 后端：Spring Boot 3.2.x + MyBatis-Plus + MySQL + Redis(可选)
- 鉴权：JWT + Spring Security

## 3. 架构事实（已验证）
- 控制器目录：`src/main/java/com/travel/controller`
- 服务实现目录：`src/main/java/com/travel/service/impl`
- 算法目录：`src/main/java/com/travel/algorithm`
- 内存数据层：`src/main/java/com/travel/storage`
- 启动预加载：`InMemoryDataLoader` 在启动时把数据库数据写入 `InMemoryStore`
- 检索索引：前缀 Trie 与 NGram 倒排索引在内存中执行检索
- 课程硬约束：数据库用于持久化；运行时核心查询/匹配/排序在内存与应用层完成
- 课程硬约束：核心算法与数据结构模块不得直接使用 Java 内置集合实现，需使用自定义结构（MyList/MyMap/MySet/MyPriorityQueue 等）

## 4. 核心功能实现状态（按 FR）
- FR-001 旅游推荐：已实现（推荐接口与个性化推荐接口存在）
- FR-003 兴趣设置：已实现
- FR-004 路线规划：已实现（含最短距离/最短时间，多点路径）
- FR-006 附近设施查询：已实现
- FR-013 美食推荐与 TopK：已实现
- FR-008/FR-009 日记管理与检索：已实现主要流程
- FR-010~FR-014 管理端核心录入：已实现部分能力
- FR-016 数据备份恢复：未见完整实现

## 5. 需求-实现差距（优先关注）
- FR-004-4 提到离线地图包；当前前端路线页主要是图拓扑可视化，非真实离线地图导航。
- FR-009-5 AIGC 旅游动画尚未发现实现。
- FR-009-4 日记压缩存储尚未发现实现。
- 自动化测试目录未发现（后端 `src/test`、前端 `*.spec.ts` 缺失）。

## 6. 重要工程风险
- 文档要求 Node 16 / Java 11，但后端 `pom.xml` 当前为 Java 21，存在环境基线不一致。
- `application.yml` 出现明文数据库账号密码，应改为环境变量注入。
- 开发日志仅记录到 2026-03-09，和当前实现进度不一致。

## 7. 团队开发约定（当前建议版）
- 每次任务必须绑定 FR 编号。
- 每次任务结束必须更新 `docs/AI/HANDOFF.md`。
- 重要技术决策必须记录在 `docs/Tech/Architecture Review v2.md` 或新建 ADR 文档。
- 提交信息使用中文，格式：`[类型] 描述`。

## 8. 快速定位命令（给任何 AI）
- 查看后端入口：`src/main/java/com/travel/TravelSystemApplication.java`
- 查看前端入口：`frontend/src/main.ts`
- 查看路由：`frontend/src/router/index.ts`
- 查看接口封装：`frontend/src/lib/api.ts`
- 查看推荐控制器：`src/main/java/com/travel/controller/RecommendationController.java`
- 查看路线服务：`src/main/java/com/travel/service/impl/RouteServiceImpl.java`
- 查看搜索索引：`src/main/java/com/travel/storage/search`
